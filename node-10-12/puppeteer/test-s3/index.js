let fs = require('fs').promises

module.exports = async () => {
  console.log('*** process.env:')

  Object.entries(process.env).forEach((k, v) => {
    console.log(`${k}: ${v}`)
  })

  console.log('AWS_ACCESS_KEY_ID from env:', process.env.AWS_ACCESS_KEY_ID)
  console.log('AWS_SECRET_ACCESS_KEY from env:', process.env.AWS_SECRET_ACCESS_KEY)
  console.log('AWS_SESSION_TOKEN from env:', process.env.AWS_SESSION_TOKEN)

  try {
    console.log('AWS_ACCESS_KEY_ID:', AWS_ACCESS_KEY_ID)
    console.log('AWS_SECRET_ACCESS_KEY:', AWS_SECRET_ACCESS_KEY)
    console.log('AWS_SESSION_TOKEN:', AWS_SESSION_TOKEN)
  } catch (err) {
    console.log('Unknown variable', err)
  }
};
