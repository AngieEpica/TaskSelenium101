# TaskSelenium101 - LambdaTest Selenium Automation

This repository contains Selenium WebDriver tests for LambdaTest's Selenium Playground, configured to run on remote browsers using LambdaTest cloud infrastructure.

## 🚀 Quick Start with Gitpod

[![Open in Gitpod](https://gitpod.io/button/open-in-gitpod.svg)](https://gitpod.io/#https://github.com/AngieEpica/TaskSelenium101)

Click the button above or use this URL:
```
https://gitpod.io/#https://github.com/AngieEpica/TaskSelenium101
```

## 📋 Prerequisites

- **LambdaTest Account**: Sign up at [lambdatest.com](https://www.lambdatest.com/)
- **LambdaTest Credentials**: Username and Access Key from your LambdaTest account

## 🛠️ Project Structure

```
TaskSelenium101/
├── src/
│   └── test/
│       └── java/
│           └── lambdaDemo/
│               ├── BaseTest.java          # Base configuration for all tests
│               ├── TestScenario1.java     # Simple form demo test
│               ├── TestScenario2.java     # Checkbox demo test
│               └── TestScenario3.java     # Input form demo test
├── drivers/                               # WebDriver binaries (if needed)
├── pom.xml                                # Maven configuration
├── .gitpod.yml                            # Gitpod configuration
└── README.md                              # This file
```

## 🔧 Running Tests in Gitpod

### Step 1: Open the Project in Gitpod

1. Click the "Open in Gitpod" button above, or
2. Navigate to: `https://gitpod.io/#https://github.com/AngieEpica/TaskSelenium101`
3. Wait for the environment to initialize (Maven dependencies will install automatically)

### Step 2: Configure LambdaTest Credentials

Update your credentials in `src/test/java/lambdaDemo/BaseTest.java`:

```java
public String username = "your-lambdatest-username@email.com";
public String accesskey = "your-lambdatest-access-key";
```

**To find your credentials:**
1. Log in to [LambdaTest](https://accounts.lambdatest.com/login)
2. Go to Settings → Access Key
3. Copy your Username and Access Key

### Step 3: Run the Tests

Open the terminal in Gitpod and run:

#### Run All Tests
```bash
mvn test
```

#### Run a Specific Test
```bash
mvn test -Dtest=TestScenario1
mvn test -Dtest=TestScenario2
mvn test -Dtest=TestScenario3
```

#### Clean and Run Tests
```bash
mvn clean test
```

## 📝 Test Scenarios

### TestScenario1: Simple Form Demo
- **URL**: https://www.lambdatest.com/selenium-playground/simple-form-demo
- **Actions**:
  1. Navigate to Simple Form Demo
  2. Validate URL contains "simple-form-demo"
  3. Enter message in text box
  4. Click "Get Checked Value"
  5. Validate displayed message matches input

### TestScenario2: Checkbox Demo
- **URL**: https://www.lambdatest.com/selenium-playground/checkbox-demo
- **Actions**:
  1. Navigate to Checkbox Demo
  2. Validate URL contains "checkbox-demo"
  3. Interact with checkboxes
  4. Validate checkbox states

### TestScenario3: Input Form Demo
- **URL**: https://www.lambdatest.com/selenium-playground/input-form-demo
- **Actions**:
  1. Navigate to Input Form Demo
  2. Fill out complete form with validation
  3. Submit form
  4. Validate form submission

## 🔍 Viewing Test Results

### In Terminal
After running tests, you'll see output like:
```
[INFO] Tests run: 1, Failures: 0, Errors: 0, Skipped: 0
[INFO] BUILD SUCCESS
RemoteWebDriver session ID: [unique-session-id]
```

### In LambdaTest Dashboard
1. Go to [LambdaTest Automation Dashboard](https://automation.lambdatest.com/)
2. Find your test by:
   - Build name: "Java Codespace Build"
   - Session ID (shown in terminal output)
   - Timestamp
3. View:
   - Video recording
   - Screenshots
   - Network logs
   - Console logs

### Local Reports
TestNG generates HTML reports in:
```
target/surefire-reports/index.html
target/surefire-reports/emailable-report.html
```

## ⚙️ Configuration

### Browser Configuration
Tests run on **Windows 10** with **Chrome (latest)** by default.

To change browser/platform, edit `BaseTest.java`:
```java
this.options.setCapability("platformName", "Windows 10");
this.options.setCapability("browserVersion", "latest");
```

### LambdaTest Options
Current configuration in `BaseTest.java`:
```java
"build": "Java Codespace Build"
"name": "LambdaTest Selenium Example"
"video": true          // Record video
"network": true        // Capture network logs
"console": true        // Capture console logs
"visual": true         // Visual regression
```

## 🐛 Troubleshooting

### Issue: "Capabilities must be set"
**Solution**: Ensure ChromeOptions are initialized in `@BeforeMethod`. This has been fixed in the current version.

### Issue: Maven dependencies not downloading
**Solution**: Run manually:
```bash
mvn clean install
```

### Issue: LambdaTest authentication failed
**Solution**: 
1. Verify credentials in `BaseTest.java`
2. Check your LambdaTest account is active
3. Ensure Access Key is correct

### Issue: Tests timing out
**Solution**: 
1. Check your internet connection
2. Increase timeout in test code:
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
```

## 📦 Dependencies

- **Selenium WebDriver**: 4.18.1
- **TestNG**: 7.9.0
- **Java**: 1.8
- **Maven**: 3.x

See `pom.xml` for complete dependency list.

## 🔗 Useful Links

- [LambdaTest Documentation](https://www.lambdatest.com/support/docs/)
- [Selenium Documentation](https://www.selenium.dev/documentation/)
- [TestNG Documentation](https://testng.org/doc/documentation-main.html)
- [Gitpod Documentation](https://www.gitpod.io/docs)

## 📄 License

This project is for educational purposes.

## 👥 Contributors

- **Angeles Cergon** - Initial work
- **Ona AI Assistant** - Configuration and documentation

---

**Last Updated**: December 10, 2025

For questions or issues, please open an issue in the GitHub repository.
