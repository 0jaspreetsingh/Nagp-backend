package com.nagarro.nagpmanagement.service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.email.SendSMTP;
import com.nagarro.nagpmanagement.io.ApplicantIO;
import com.nagarro.nagpmanagement.io.ApplicantMonthlyReport;
import com.nagarro.nagpmanagement.model.Applicant;
import com.nagarro.nagpmanagement.repository.AdminRepository;
import com.nagarro.nagpmanagement.util.GenerateExcelFile;
import com.nagarro.nagpmanagement.util.GetExcelFiles;

@Service
public class AdminServices {

	@Autowired
	AdminRepository adminrepository;

	@Autowired
	ApplicantActivityServices appActservice;

	@Autowired
	ApplicantServices appService;

	public boolean authenticate(String username, String password) {
		return adminrepository.match(username, password) != null ? true : false;
	}

	public List<ApplicantMonthlyReport> generateReport() throws IOException {
		List<Applicant> applicants = appService.showAll();
		List<ApplicantMonthlyReport> reports = new ArrayList<ApplicantMonthlyReport>();
		ApplicantMonthlyReport report;
		for (Applicant applicant : applicants) {
			report = new ApplicantMonthlyReport();
			report.setApplicantName(applicant.getName());
			report.setEmail(applicant.getEmail());
			report.setEmployee_id(applicant.getEmployee_id());
			ApplicantIO applicantIo = new ApplicantIO();
			applicantIo.setEmployee_id(applicant.getEmployee_id());
			double points = appService.getPoints(applicantIo);
			report.setPointsEarned((int) points);
			report.setTotalPoints(applicant.getLevel().getQualification_points());
			// number of nagp activities in progress
			int totalActivitiesInProgress = appActservice.activitiesInProgress(applicant.getEmployee_id());
			report.setTotalActivitiesInProgress(totalActivitiesInProgress);
			report.setBatchName(applicant.getBatch().getTechnology() + applicant.getBatch().getYear());
			reports.add(report);
			System.out.println(report);
		}

		return reports;
	}

	public ApplicantMonthlyReport getApplicantReport(String employee_id) {

		ApplicantMonthlyReport report = new ApplicantMonthlyReport();
		Applicant applicant = appService.getById(Integer.parseInt(employee_id));
		report.setApplicantName(applicant.getName());
		report.setEmail(applicant.getEmail());
		report.setEmployee_id(applicant.getEmployee_id());
		ApplicantIO applicantIo = new ApplicantIO();
		applicantIo.setEmployee_id(Integer.parseInt(employee_id));
		double points = appService.getPoints(applicantIo);
		report.setPointsEarned((int) points);
		report.setTotalPoints(applicant.getLevel().getQualification_points());
		// number of nagp activities in progress
		int totalActivitiesInProgress = appActservice.activitiesInProgress(Integer.parseInt(employee_id));
		report.setTotalActivitiesInProgress(totalActivitiesInProgress);
		report.setBatchName(applicant.getBatch().getTechnology() + "|" + applicant.getBatch().getYear());
		System.out.println(report);
		return report;
	}

	public void createAndOrganiseReports() throws IOException {
		List<ApplicantMonthlyReport> reports = generateReport();
		HashMap<String, List<ApplicantMonthlyReport>> batchWiseReports = new HashMap<String, List<ApplicantMonthlyReport>>();
		for (ApplicantMonthlyReport report : reports) {
			SendSMTP.sendMail(report.getEmail(), report.toString(), "Monthly Report", null); // send mail to each
																								// employee about
																								// its own details
			if (batchWiseReports.containsKey(report.getBatchName())) {
				List<ApplicantMonthlyReport> list = batchWiseReports.get(report.getBatchName());
				list.add(report);
			} else {
				List<ApplicantMonthlyReport> list = new ArrayList<ApplicantMonthlyReport>();
				list.add(report);
				batchWiseReports.put(report.getBatchName(), list);
			}
		}

		for (String key : batchWiseReports.keySet()) {
			GenerateExcelFile.generateExcelfile(batchWiseReports.get(key)); // generate and store excel files
		}
		GetExcelFiles getFiles = new GetExcelFiles(NAGPconstants.GENERATED_EXCEL_FILES_PATH);
		File excelFiles[] = getFiles.read();
		SendSMTP.sendMail(NAGPconstants.ADMIN_EMAIL_ID, "Batch Wise reports", "Monthly Report", excelFiles);

	}
}
