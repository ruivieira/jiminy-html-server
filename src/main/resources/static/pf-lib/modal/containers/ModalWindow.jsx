import React,{Component} from 'react';
import { connect } from "react-redux";
import Modal from 'react-modal';
import PropTypes from 'prop-types';
import { toggleModal } from '../../modal/modalActions'

export class ModalComponentDialog extends Component{
  // Ensure that the toggleModal is the same that is passed to
  // ButtonModal
  static get propTypes() {
    return {
      mid: PropTypes.string.isRequired,
      toggleModal: PropTypes.func.isRequired,
      modalState: PropTypes.object.isRequired,
      modalTitle: PropTypes.string.isRequired,
      modalContent: PropTypes.element.isRequired,
      modalFooter: PropTypes.element,
    }
  }

  constructor(props){
    super(props);
    this.closeModal = this.closeModal.bind(this);
  }

  closeModal(){
    this.props.toggleModal(this.props.mid);
  }

  /* Create Modal on first render if it doesn't exist */
  createModal() {
    if (this.props.modalState[this.props.mid] === undefined) {
      this.props.modalState[this.props.mid] = false;
    }
  }

  render(){
    this.createModal();

    /*const status = modalStatus ? "Verdadero": "Falso";*/
    let footer = null;
    if(this.props.modalFooter){
      footer = this.props.modalFooter;
    }else {
      footer =
        <div className="modal-footer">
          <button type="button" className="btn btn-secondary" data-dismiss="modal" onClick={this.closeModal}>Close</button>
        </div>
    }

    return (
      <div>
        <Modal
          isOpen={this.props.modalState[this.props.mid]}
          contentLabel="Modal"
          onRequestClose={this.closeModal}
          className="modal-dialog">
          <div className="modal-content">
            <div className="modal-header">
              <button type="button" className="close" onClick={this.closeModal} data-dismiss="modal" aria-label="Close">
                <span aria-hidden="true">&times;</span>
              </button>
              <h4 className="modal-title">{this.props.modalTitle}</h4>
            </div>
            <div className="modal-body">
              {this.props.modalContent}
            </div>
            {footer}
          </div>
        </Modal>
      </div>
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

export default connect(mapStateToProps, mapDispatchToProps)(ModalComponentDialog);

