import React, { Component } from "react";
import PropTypes from "prop-types";

export class ChartComponent extends Component{

  static get propTypes() {
    return {
      config: PropTypes.shape({
        bindto: PropTypes.string.isRequired,
        data: PropTypes.shape({
          columns: PropTypes.array.isRequired
        }).isRequired
      }).isRequired,
      element: PropTypes.string,
      generateCallback: PropTypes.func,
    }
  }

  constructor(){
    super();
  }

  shouldComponentUpdate(nextProps) {
    if(this.props.config.data.columns.length
      !== nextProps.config.data.columns.length) { // shallow check
      return true;
    } else if(JSON.stringify(this.props.config.data.columns)
      !== JSON.stringify(nextProps.config.data.columns)) { // deeper check
      return  true;
    }
    return false;
  }

  componentDidMount() {
    this._generateChart(
      this.props.config,
    );
  }

  componentDidUpdate(prevProps) {
    if(prevProps.config.data.columns !== this.props.config.data.columns) {
      this._generateChart(this.props.config);
    }
  }

  componentWillUnmount() {
    this._destroyChart();
  }

  _generateChart(config) {
    this.chart = c3.generate(config);
    if(this.props.generateCallback !== undefined) this.props.generateCallback();
  }

  _destroyChart() {
    this.chart.destroy();
  }

  render() {
    return (
      <div className="c3 react-c3" id={this.props.element}/>
    );
  }
}


export default ChartComponent;