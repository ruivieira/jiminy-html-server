import React from 'react';
import ChartComponent from '../../c3Charts/chart.jsx';
import { CHART_CONFIG } from "./chartData";
import { shallow } from 'enzyme';
import sinon from 'sinon';

function setup(useCallback = false) {
  // Mock out c3 calls
  global.c3 = jest.fn();
  global.c3.generate = jest.fn();

  // Use a spy as a callback invoked after c3 generate
  const spyCallback = sinon.spy();
  const props = {
    config: CHART_CONFIG.lineA,
    element: "chart-pf-sparkline",
  };

  if(useCallback) props.generateCallback = spyCallback;

  const enzymeWrapper = shallow(<ChartComponent {...props}/>, { lifecycleExperimental: true });

  return {
    props,
    enzymeWrapper,
    spyCallback
  }
}

describe('Charts ->', () => {

  it.only('Chart should exist.', () => {
    const { enzymeWrapper, props} = setup();
    const chart = enzymeWrapper.find('.c3');
    expect(chart).to.have.length(1);
  });

  it.only('Should invoke callback after generate', () => {
    const { enzymeWrapper, props, spyCallback} = setup(true);
    expect(spyCallback).to.have.property('callCount', 1);
  });

  it.only('Should not invoke callback after generate', () => {
    const { enzymeWrapper, props, spyCallback} = setup();
    enzymeWrapper.instance().componentDidMount();
    expect(spyCallback).to.have.property('callCount', 0);
  });

  it.only('shouldComponentUpdate should return true on new chart config', () => {
    const { enzymeWrapper, props, spy} = setup();
    const shouldUpdate = enzymeWrapper.instance().shouldComponentUpdate({config: CHART_CONFIG.lineB});
    expect(shouldUpdate).to.be.true;
  });

  it.only('shouldComponentUpdate should return false on old chart config', () => {
    const { enzymeWrapper, props, spy} = setup();
    const shouldUpdate = enzymeWrapper.instance().shouldComponentUpdate({config: CHART_CONFIG.lineA});
    expect(shouldUpdate).to.be.false;
  });

  it.only('Should destroy chart on unmount', () => {
    const spyDestroy = sinon.spy();
    const { enzymeWrapper, props, spyCallback} = setup();
    enzymeWrapper.instance().chart = jest.fn();
    enzymeWrapper.instance().chart.destroy = spyDestroy;
    enzymeWrapper.instance().componentWillUnmount();
    expect(spyDestroy).to.have.property('callCount', 1);
  });

  it.only('componenetDidUpdate Should invoke re-generate chart, if data changed', () => {
    const { enzymeWrapper, props, spyCallback} = setup(true);
    // Pass a prevprops intentionally different from the current this.props.config
    const prevProps = {...props, config: CHART_CONFIG.lineB};
    enzymeWrapper.instance().componentDidUpdate(prevProps);
    expect(spyCallback).to.have.property('callCount', 2);
  });

});