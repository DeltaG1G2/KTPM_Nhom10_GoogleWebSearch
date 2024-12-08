# KTPM_Nhom11

# Automated Testing for Google Search Using Selenium

This project implements automated testing for Google Search functionality using Selenium WebDriver and Selenium IDE.

## Project Structure

```
shopee_test/
├── src/test/java/
│   └── EnhancedGoogleTest.java    # Java-based test cases
├── Google_selenium.side           # Selenium IDE test suite
├── pom.xml                       # Maven dependencies
└── README.md                     # Project documentation
```

## Test Cases

1. **Basic Search Test**: Verifies basic search functionality
2. **Search Suggestions Test**: Tests search suggestions feature
3. **I'm Feeling Lucky Test**: Tests "I'm Feeling Lucky" button with Google Translate
4. **Special Characters Search Test**: Tests search with special characters
5. **First Result Link Test**: Verifies clicking first search result
6. **Multilingual Search Test**: Tests search with non-English text
7. **Pagination Test**: Tests navigation through search results pages
8. **Image Search Test**: Tests Google image search functionality

## Technologies Used

- Selenium WebDriver 3.141.59
- Selenium IDE
- JUnit 4
- Maven
- ChromeDriver
- Java 8+

## Setup & Running Tests

1. Install dependencies:
   ```bash
   mvn clean install
   ```

2. Run Selenium IDE tests:
   ```bash
   selenium-side-runner Google_selenium.side
   ```

3. Run Java tests:
   ```bash
   mvn test
   ```

## Team Members & Contributions

| Name | Student ID | Contribution | Percentage |
|------|------------|--------------|------------|
| Lê Trương Gia Bảo | 3120221006 | - Project setup & architecture<br>- Selenium IDE test suite development<br>- Documentation & code review | 30% |
| Lê văn A | 300000000 | - Basic search test cases<br>- Search suggestions implementation<br>- Bug fixes & improvements | 24% |
| Lê văn B | 300000000 | - Pagination test cases<br>- Image search implementation<br>- Test stability improvements | 24% |
| Lê văn C | 300000000 | - Multilingual test cases<br>- Special characters testing<br>- Code optimization | 24% |

## Key Features

- Robust wait strategies for dynamic elements
- Cross-browser compatibility
- Comprehensive test coverage
- Clear test reporting
- Maintainable test structure

## Best Practices Implemented

1. Explicit waits for better reliability
2. Proper element locator strategies
3. Error handling and recovery
4. Clean code structure
5. Comprehensive documentation

## Future Improvements

1. Add more test scenarios
2. Implement parallel test execution
3. Add detailed test reporting
4. Enhance error handling
5. Add visual regression testing

## Notes

- Tests are designed to handle Google's dynamic UI
- Regular maintenance may be required due to Google's frequent updates
- Some tests may need adjustment based on Google's regional settings

---
Last Updated: December 8, 2024
