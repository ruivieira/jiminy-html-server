import React, { Component } from "react";
import { BrowserRouter as Router, Route, Switch } from "react-router-dom";
import PropTypes from "prop-types";
import NavBar from "../navBar/components/NavBar.jsx";
import Message from "../message/container/Message.jsx";

export class App extends Component {

  static get propTypes() {
    return {
      // Config Props, inherited from parent
      viewsConfig: PropTypes.array.isRequired,
      navbarConfig: PropTypes.object.isRequired,
      customNavUtility: PropTypes.oneOfType([
        PropTypes.array,
        PropTypes.element
      ]),
      autoNavUtility: PropTypes.oneOfType([
        PropTypes.array,
        PropTypes.element
      ]),
    }
  }

  _createSwitches(){
    return (
      this.props.viewsConfig.map((view, i) => {
          return (
            <Switch key={i}>
              <Route exact path={view.path} component={view.component}/>
            </Switch>
          )
        }
      )
    )
  }

  _createNavBar(){
    if(this.props.customNavUtility !== undefined){
      return <NavBar config={this.props.navbarConfig} customUtility={this.props.customNavUtility}/>
    }else if(this.props.autoNavUtility !== undefined){
      return <NavBar config={this.props.navbarConfig} autoUtility={this.props.autoNavUtility}/>
    }
    return (
      <NavBar config={this.props.navbarConfig}/>
    )
  }

  render() {
    return (
      <Router>
        <div className="app">
          {this._createNavBar()}
          <Message/>
          {this._createSwitches()}
        </div>
      </Router>
    );
  }
}

export default App;
