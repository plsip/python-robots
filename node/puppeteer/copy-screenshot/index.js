let fs = require('fs').promises

module.exports = async () => {
  try {
    console.log('Copying a screenshot from shared path to screenshots path')
    await fs.copyFile(`${process.env.SHARED_ORDER_PATH}/efs-test-07092020.png`, `${process.env.SCREENSHOTS_PATH}/copied-from-shared-07092020.png`)
    console.log('The file has been copied successfully.')

    return {
      success: true
    }
  } catch (err) {
    console.log('Failed to copy to the file:', err)
  }
};
