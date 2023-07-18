package com.codprog.reporting;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
    public static final ExtentReports extentReports = new ExtentReports();

    public synchronized static ExtentReports createExtentReports() {
        ExtentSparkReporter reporter = new ExtentSparkReporter("report.html");
        reporter.config().setReportName("Test Run Report");
        extentReports.attachReporter(reporter);
        extentReports.setSystemInfo("Author", "Jagriti Sharma");
        return extentReports;
    }
}
