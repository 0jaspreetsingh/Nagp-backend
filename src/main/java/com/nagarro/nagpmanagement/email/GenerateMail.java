package com.nagarro.nagpmanagement.email;

import java.io.IOException;

import com.nagarro.nagpmanagement.io.ApplicantMonthlyReport;

public class GenerateMail {

	public void sendMailToApplicant(ApplicantMonthlyReport report) throws IOException {
		SendSMTP.sendMail(report.getEmail(), report.toString(), "Activity Report",null);
	}
}
