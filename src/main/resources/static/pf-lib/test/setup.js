import chai from "chai";
import chaiEnzyme from "chai-enzyme";

import jquery from '../node_modules/patternfly/node_modules/jquery/dist/jquery.min';

// Chai / jest globals
chai.use(chaiEnzyme());

global.jestExpect = global.expect;
global.expect = chai.expect;

global.$ = jquery;
global.jQuery = jquery;
global.window.jquery = jquery;
global.window.jQuery = jquery;



