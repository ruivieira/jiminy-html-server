import React,{ Component } from 'react';
import PropTypes from 'prop-types';
import { connect } from "react-redux";
import { toggleModal } from '../../modal/modalActions'

export class ButtonComponent extends Component{
  // Ensure that the toggleModal is the same that is passed to
  // ModalComponentDialog
  static get propTypes() {
    return {
      toggleModal: PropTypes.func,
      mid: PropTypes.string,
      content: PropTypes.element
    }
  }

  constructor(props){
    super(props);
    this.openModel = this.openModel.bind(this);
  }

  openModel(){
    this.props.toggleModal(this.props.mid);
  }

  render(){
    return (
      <span className="pointer" onClick={this.openModel}>
        {this.props.content}
      </span>
    );
  }
}

const mapStateToProps = (state) => {
  return {
    modalState: state.modalReducer.modals,
  }
};

const mapDispatchToProps = (dispatch) => {
  return {
    toggleModal: (mid) => {
      dispatch(toggleModal(mid))
    },
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(ButtonComponent);



