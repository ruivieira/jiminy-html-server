# Introduction
The reactjs/redux patternfly library allows you re-use standard components (styled using Patternfly) throughout your app. The following features are currently offered:

Status Messages
Popup Modals
Navbar
App Container
Getting Started
First ensure that your project webconfig has the Patternfly assets imported as plugins. This can be accomplished using CopyWebpackPlugin(), see example below:

```javascript

plugins: [
      //copy patternfly assets
      new CopyWebpackPlugin([
          {
              from: { glob: './node_modules/patternfly/dist/img/*.*'},
              to: './img',
              flatten: true
          },
          {
              from: { glob: './node_modules/patternfly/dist/fonts/*.*'},
              to: './fonts',
              flatten: true
          },
          {
              from: { glob: './node_modules/patternfly/dist/css/*.*'},
              to: './css',
              flatten: true
          },
          {
              from: { glob: './node_modules/react-bootstrap-table/css/*.*'},
              to: './css',
              flatten: true
          }
      ])

```

Add the library by forking/cloning:

```bash
git clone https://github.com/zmhassan/reactjs-redux-patternfly-library.git
```
Or as a submodoule:

```bash
git submodule add https://github.com/zmhassan/reactjs-redux-patternfly-library /some/path
```
If you encounter problems when adding as a submodule, see here, for possible suggestions.

Each package is decoupled and if you require only a single folder you may choose to do so:

```bash
git submodule add https://github.com/zmhassan/reactjs-redux-patternfly-library/modal /some/path
```
See CSS page for the required styling.

See Dependencies for the required dependencies.

See App Container to link up your first app.

Documentation can be found here: https://zmhassan.gitbooks.io/reactjs-redux-patternfly-library/
