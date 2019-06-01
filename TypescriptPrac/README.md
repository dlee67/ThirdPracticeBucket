# Initialize a new NPM project (follow the prompts)
npm init

# Install TSC, TSLint, and type declarations for NodeJS
npm install --save-dev typescript tslint @types/node

# I need to execute those two in a sequence, or things won't work.

# All TypeScript project must have tsconfig.js in their root folder.

#There is something called tslint.json, not sure what it is, but
./node_modules/.bin/tslint --init
#The above will generate a convention...?

#Whatever code you have, you can compile it via
./node_modules/.bin/tsc
#Of course, this is executed while on root folder.
#After runnint the tsc, you can notice the JavaScript code being generated ...
