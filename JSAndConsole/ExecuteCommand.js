function executeHCCommand(){
  var command = document.getElementById("HCInput").value;
  const output = execSync(command.toString(), { encoding: 'utf-8' });  // the default is 'buffer'
  console.log(output);
}
