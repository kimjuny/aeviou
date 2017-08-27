const path = require('path')
const fs = require('fs')
const fse = require('fs-extra')
const yaml = require('js-yaml')

const root = path.resolve(__dirname, '../')
const config = `${root}/keys.yml`
const file = `${root}/src/views/utils/keys.js`

try {
  const doc = yaml.safeLoad(fs.readFileSync(config, 'utf8'))
  fse.removeSync(file)
  fse.outputFileSync(file, `export default ${JSON.stringify(doc)}`)

  console.log('keys.yml has loaded.')
} catch (e) {
  console.error(e)
}
