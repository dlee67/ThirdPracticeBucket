const { app } = require('electron')
const BrowserWindow = require('browser-window');

app.on('ready', () => {
  console.log('Application ready!')

  let mainWindow = new BrowserWindow({
    show: false,
    width: 1000,
    height: 800
  })

  mainWindow.webContents.on('dom-ready', () => {
    // The window has loaded its contents
    mainWindow.show()
  })

  mainWindow.loadURL(`file://${__dirname}/../renderer/index.html`)
})
