module.exports = async browser => {
  let page = await browser.newPage()

  let urls = {
    mir: 'https://makeitright.ai',
    google: 'https://google.com',
    paypal: 'https://paypal.com',
    react: 'https://reactjs.org'
  }

  for await (let [name, url] of Object.entries(urls)) {
    await page.goto(url)
    console.log('Saving a screenshot in the file manager');
    await page.screenshot({ path: `${process.env.FILE_MANAGER_PATH}/${name}.png` })
  }

  return {
    success: true
  }
}
