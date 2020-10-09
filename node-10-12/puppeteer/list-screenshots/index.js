let fs = require('fs').promises
let { resolve } = require('path');

async function getFiles(dir) {
  const dirents = await fs.readdir(dir, { withFileTypes: true });
  const files = await Promise.all(dirents.map((dirent) => {
    const res = resolve(dir, dirent.name);
    return dirent.isDirectory() ? getFiles(res) : res;
  }));
  return Array.prototype.concat(...files);
}

module.exports = async () => {
  console.log('Listing files in shared directory');

  try {
    let files = await getFiles('/mnt/shared')

    files.forEach(file => console.log)

    return { files }
  } catch (err) {
    console.log('Failed to list files due to error:', err)
  }
};
