const loadMonaco = require('monaco-loader')

loadMonaco().then((monaco) => {
  const element = document.querySelector('#container')
  const options = {
    language: 'javascript',
    theme: 'vs-dark',
    automaticLayout: true
  }

  const editor = monaco.editor.create(element, options)
})
