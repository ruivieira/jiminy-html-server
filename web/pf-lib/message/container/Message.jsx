import React, { Component } from "react";
import PropTypes from "prop-types";
import ReactCSSTransitionReplace from "react-css-transition-replace";
import { connect } from "react-redux";
import { clearMessage } from "../messageActions";

export class Message extends Component {
  static get propTypes() {
    return {
      message: PropTypes.string,
      messageType: PropTypes.string,
      icon: PropTypes.string,
      visible: PropTypes.bool,
      clearMessage: PropTypes.func
    }
  }

  handleClick() {
    this.props.clearMessage();
  }

  render() {
    return (
      <ReactCSSTransitionReplace
        transitionName="fade"
        transitionEnterTimeout={1000}
        transitionLeaveTimeout={1000}>
        {this.props.visible &&
        <div className={"alert alert-" + this.props.messageType + " alert-dismissable"}>
          <button type="button" className="close" data-dismiss="alert" aria-hidden="true" onClick={this.handleClick.bind(this)}>
            <span className="pficon pficon-close"/>
          </button>
          <span className={"pficon pficon-" + this.props.icon}/>
          {this.props.message}
        </div>}
      </ReactCSSTransitionReplace>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    message: state.messageReducer.message,
    messageType: state.messageReducer.messageType,
    icon: state.messageReducer.icon,
    visible: state.messageReducer.visible,
  }
};

const mapDispatchToProps = (dispatch) => {
  return {
    clearMessage: () => {
      dispatch(clearMessage())
    },
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(Message);
