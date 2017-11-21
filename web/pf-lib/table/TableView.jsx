import React, { Component } from "react";
import PropTypes from 'prop-types';
import TableFooter from './TableFooter.jsx';

class Table extends Component {
  static get propTypes() {
    return {
      config: PropTypes.object.isRequired,
    }
  }

  shouldComponentUpdate(nextProps) {
    /* Table has not been created (see ComponentDidMount()).*/
    if(this.props.config.data.length === 0)
      return true;
    else if (nextProps.config.data !== this.props.config.data)
      this._reloadTableData(nextProps.config.data);

    return false;
  }

  _reloadTableData(data) {
    const table = $(this.table).DataTable();
    table.clear();
    table.rows.add(data);
    table.draw();
  }

  render() {
    return (
    <div>
      <table ref={table => this.table = table }
             className="table table-striped table-bordered table-hover"
             id="table1"/>
      <TableFooter/>
    </div>
    )
  }

  componentDidUpdate(){
    if(this.props.config.data.length !== 0)
      $(this.table).DataTable(this.props.config);
  }

  componentDidMount() {
    if(this.props.config.data.length !== 0)
      $(this.table).DataTable(this.props.config);
  }

  componentWillUnmount(){
    $(this.table).DataTable().destroy();
  }
}

export default Table
