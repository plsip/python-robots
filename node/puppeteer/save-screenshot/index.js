module.exports = async (browser, { inputParameters }) => {
  let websiteUrl = inputParameters.websiteUrl || 'https://makeitright.ai'

  const page = await browser.newPage()

  await page.goto(websiteUrl)

  console.log('Saving a screenshot in shared directory');

  await page.screenshot({ path: `${process.env.SHARED_ORDER_PATH}/efs-test-07092020.png` })

  return {
    success: true
  }
}
