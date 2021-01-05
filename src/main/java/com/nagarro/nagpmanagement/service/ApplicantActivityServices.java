package com.nagarro.nagpmanagement.service;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.nagpmanagement.constants.NAGPconstants;
import com.nagarro.nagpmanagement.email.SendSMTP;
import com.nagarro.nagpmanagement.io.ApplicantActivityIO;
import com.nagarro.nagpmanagement.model.ApplicantActivityRecord;
import com.nagarro.nagpmanagement.repository.ApplicantActivityRepository;

@Service
public class ApplicantActivityServices {

	@Autowired
	SendSMTP sendMail;

	@Autowired
	ApplicantActivityRepository aar;

	public String add(ApplicantActivityRecord record) throws IOException {
		String message = "";
		List<ApplicantActivityRecord> list = aar.isRecordAlreadyPresent(record.getActivity_id(), record.getAssignee(),
				record.getLevel_id());
		if (list.size() >= record.getActivity_id().getMax_qualification()) {
			message = "Max attempts for enrolling in this activity are reached,Please select some other activity";
		} else {
			record.setStatus("PLANNED");
			int points = record.getActivity_id().getPoints();
			record.setPoints(points);
			ApplicantActivityRecord appActRec = aar.save(record);
			if (appActRec != null) {
				message = "Activity Enrolled Succesfully.";
				try {
					String mailMessage = record.getActivity_id().getName() + " Activity of level "
							+ record.getLevel_id().getName() + "is succesfully enrolled";
					SendSMTP.sendMail(record.getAssignee().getEmail(), mailMessage, "Activity Enrolled", null);
					message += "please check your mail for further details";
				} catch (Exception e) {
					message += "But there was an error sending the mail";
				}

			} else {
				message = "an error occoured while enrolling you into activity ,please try after some time";
			}
		}
		return message;
	}

	public List<ApplicantActivityRecord> isRecordPresentforApplicant(ApplicantActivityRecord record) {
		List<ApplicantActivityRecord> list = aar.isRecordAlreadyPresent(record.getActivity_id(), record.getAssignee(),
				record.getLevel_id());
		if (!list.isEmpty()) {
			System.out.println("in inside isRecordPresentforApplicant");
			return list;
		} else
			return null;
	}

	public List<ApplicantActivityRecord> getAll() {
		return aar.findAll();
	}

	public List<ApplicantActivityIO> filterByEmployeeId(String employee_id) {

		List<ApplicantActivityRecord> records = aar.filterByEmployeeId(employee_id);

		List<ApplicantActivityIO> appActIO = new ArrayList<ApplicantActivityIO>();
		ApplicantActivityIO data;
		for (ApplicantActivityRecord record : records) {
			data = new ApplicantActivityIO();
			data.setActivity_id(record.getActivity_id().getActivity_id());
			data.setApplicantActvityId(record.getApplicantActvityId());
			data.setCompletiondate(record.getCompletiondate());
			data.setDescription(record.getActivity_id().getDescription());
			data.setDonedate(record.getDonedate());
			data.setEmployee_id(record.getAssignee().getEmployee_id());
			data.setLevel(record.getLevel_id());
			data.setName(record.getActivity_id().getName());
			data.setPoints(record.getPoints());
			data.setScore(record.getScore());
			data.setStartdate(record.getStartdate());
			data.setStatus(record.getStatus());

			appActIO.add(data);
		}

		return appActIO;
	}

	public List<ApplicantActivityRecord> getEmployeeActivityfullRecord(String employee_id) {
		return aar.filterByEmployeeId(employee_id);
	}

	public ApplicantActivityRecord getById(int id) {
		return aar.getOne(id);
	}

	public ApplicantActivityIO changeStatus(int applicantActvityId, String status, int score) {
		// String message;
		SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd");// dd/MM/yyyy
		String date = sdfDate.format(Calendar.getInstance().getTime());
		ApplicantActivityRecord appActRecord = aar.getOne(applicantActvityId);
		// System.out.println(Calendar.getInstance().toString());
		if (NAGPconstants.IN_PROGRESS.equals(status)) {
			appActRecord.setStartdate(date);
		} else if (NAGPconstants.DONE.equals(status)) {
			appActRecord.setDonedate(date);
		} else if (status != null && status.startsWith(NAGPconstants.COMPLETED)) { // also assign score
			appActRecord.setCompletiondate(date);
			appActRecord.setScore(score);

			float points = (score * appActRecord.getActivity_id().getPoints() / 100);
			appActRecord.setPoints((int) points);
		} else {
			// ie status is in review pending or review failed , So do nothing
			// also if status is review pending , store somewhere details to remind admin
			// that they have to update status further
		}
		appActRecord.setStatus(status);
		appActRecord = aar.save(appActRecord);
		ApplicantActivityIO appActRecordIO = null;
		if (appActRecord != null) {
			appActRecordIO = new ApplicantActivityIO();
			appActRecordIO.setActivity_id(appActRecord.getActivity_id().getActivity_id());
			appActRecordIO.setApplicantActvityId(appActRecord.getApplicantActvityId());
			appActRecordIO.setCompletiondate(appActRecord.getCompletiondate());
			appActRecordIO.setDescription(appActRecord.getActivity_id().getDescription());
			appActRecordIO.setDonedate(appActRecord.getDonedate());
			appActRecordIO.setEmployee_id(appActRecord.getAssignee().getEmployee_id());
			appActRecordIO.setLevel(appActRecord.getLevel_id());
			appActRecordIO.setName(appActRecord.getActivity_id().getName());
			appActRecordIO.setPoints(appActRecord.getPoints());
			appActRecordIO.setScore(appActRecord.getScore());
			appActRecordIO.setStartdate(appActRecord.getStartdate());
			appActRecordIO.setStatus(appActRecord.getStatus());

		}
		return appActRecordIO;
	}

	public int activitiesInProgress(int employee_id) {
		return aar.getnumberOfActivitiesInProgress(employee_id);
	}
}
