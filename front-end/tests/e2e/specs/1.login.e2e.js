const data = require('../data/user')

module.exports = {
  'login page renders elements': function (browser) {
    const loginPage = browser.page.LoginPage()

    loginPage
      .navigate()
      .waitForElementVisible('@app', 500)
      .assert.visible('@usernameInput')
      .assert.visible('@passwordInput')
      .assert.visible('@submitButton')
      .assert.hidden('@formError')

    browser.end()
  },
  'login with invalid credentials': function (browser) {
    const loginPage = browser.page.LoginPage()
    loginPage
      .navigate()
      .login('not-exist', 'incorrect')

    browser.pause(500)

    loginPage
      .assert.visible('@formError')
      .assert.containsText('@formError', 'Invalid credentials')

    browser
      .assert.urlEquals(browser.launchUrl + 'login')
      .end()
  },
  
}
