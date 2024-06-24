# OpenCartJavaSeleniumTestngAllure
[![Java CI with Maven](https://github.com/DenisProkofyev/OpenCartJavaSeleniumTestngAllure/actions/workflows/build.yml/badge.svg)](https://github.com/DenisProkofyev/OpenCartJavaSeleniumTestngAllure/actions/workflows/build.yml)
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <title>OpenCart Java Selenium TestNG Allure</title>
</head>

<body>
  <h1>OpenCart Java Selenium TestNG Allure</h1>

  <p>
        This project is a test automation suite for the OpenCart online shop, utilizing Java, Selenium WebDriver,
        TestNG, and Allure and Test Reporter for reporting. Tests are executed daily via Jenkins for continuous integration and cross-browser
        compatibility.
  </p>

<h2>Project Structure</h2>
<div class="project-structure">
<pre>
OpenCartJavaSeleniumTestngAllure/
├── .github/
│   └── workflows/
│       └── build.yml
├── src/
│   ├── test/
│   │   └── java/
│   │       └── com/
│   │           └── opencart/
│   │               ├── base/
│   │               │   └── BaseTest.java
│   │               │   └── TestUtils.java
│   │               ├── data/
│   │               │   └── ProductIdData.java
│   │               │   └── TestData.java
│   │               ├── model/
│   │               ├── test/
│   │               │   └── CartTest.java
│   │               │   └── LoadingTest.java
│   │               │   └── NavigationTest.java
│   │               │   └── ProductTest.java
│   │               │   └── SearchTest.java
│   │               ├── utils/
│   │               │   └── DriverUtils.java
│   │               │   └── ProjectUtils.java
│   │               │   └── ReportUtils.java
│   │               ├── FrameworkTest.java
├── target/
│   ├── allure-results/
├── xmlSuits/
├── pom.xml
└── README.md
</pre>
</div>

<h3>Testing Framework</h3>
    <ul>
        <li>Utilizes the <strong>Page Object Model</strong> (POM) pattern for structured and reusable test code.</li>
        <li>Supports cross-browser testing and multiple operating systems.</li>
        <li>Data-driven tests with <code>DataProvider</code> for comprehensive test coverage.</li>
    </ul>

<h3>Key Features</h3>
    <ul>
        <li>Comprehensive test coverage for OpenCart functionalities: navigation, login, purchasing, search, and file
            loading.</li>
        <li>ThreadLocalDriver for thread-safe WebDriver instances.</li>
        <li>Extensive logging for debugging and tests execution tracking.</li>
    </ul>

<h2>Operating Systems</h2>
    <p>The CI pipeline is configured to run on the following operating systems:</p>
    <ul>
        <li><strong>Ubuntu (latest)</strong></li>
        <li><strong>Windows (latest)</strong></li>
        <li><strong>macOS (version 13)</strong></li>
    </ul>

<h2>Cross-Browser Testing</h2>
    <p>The tests are executed on two browsers to ensure compatibility:</p>
    <ul>
    <li><strong>Google Chrome</strong></li>
    <li><strong>Mozilla Firefox</strong></li>
    </ul>

<h2>CI Configuration</h2>
    <p>The CI workflow is defined in the <code>.github/workflows/build.yml</code> file. It includes the following steps:</p>
    <ol>
        <li><strong>Clone Repository</strong>: Checks out the code from the repository.</li>
        <li><strong>Set Up JDK 17</strong>: Sets up Java Development Kit version 17.</li>
        <li><strong>Cache Maven Dependencies</strong>: Caches the Maven dependencies to speed up the build process.</li>
        <li><strong>Install Firefox on macOS</strong>: Installs Firefox on macOS 13.</li>
        <li><strong>Build with Maven</strong>: Compiles the project and skips tests initially.</li>
        <li><strong>Run Tests</strong>: Executes different test suites based on the operating system and browser.</li>
        <li><strong>Generate Reports</strong>: Creates test reports using Allure and uploads them to GitHub Pages.</li>
    </ol>

<h2>Running Tests</h2>
<h4>Running Tests is performed on different browsers and operating systems via profiles for Google Chrome and Firefox.</h4>
<p>For instance:</p>
<h4>Ubuntu Cross-Browser Testing</h4>
  <pre><code>
    mvn test -Dsurefire.suiteXmlFiles=xmlSuits/crossBrowser.xml
  </code></pre>

<h4>Windows with Chrome</h4>
  <pre><code>
    mvn test -Pchrome '-Dsurefire.reportNameSuffix=chrome'
  </code></pre>

<h4>macOS with Firefox</h4>
  <pre><code>
    mvn test -Pfirefox -Dsurefire.reportNameSuffix=firefox
  </code></pre>

<h2>GitHub Actions CI</h2>
  <p>This project uses GitHub Actions for Continuous Integration. </p>

<h2>Test Reporting</h2>
  <p>Test results are generated with Test Reporter for all operating systems, Allure Reports are generated for Ubuntu. Locally you can view the Allure report by running:</p>
  <pre><code>
    mvn allure:serve
  </code></pre>

<h2>Running the Tests Locally</h2>
<ol>
<li><strong>Clone the repository</strong>:
<pre><code>git clone https://github.com/DenisProkofyev/OpenCartJavaSeleniumTestngAllure.git
cd OpenCartJavaSeleniumTestngAllure
</code></pre>
</li>
<li><strong>Install dependencies</strong>:
<pre><code>mvn clean install
</code></pre>
</li>
<li><strong>Run the tests</strong>:
<pre><code>mvn test
</code></pre>
</li>
</ol>
</body>
