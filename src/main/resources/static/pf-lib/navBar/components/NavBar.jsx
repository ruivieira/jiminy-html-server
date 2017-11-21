import React, { Component } from "react";
import { NavItem, Navbar, Nav } from "react-bootstrap";
import { IndexLinkContainer, LinkContainer } from "react-router-bootstrap";
import { Link } from "react-router-dom";
import PropTypes from "prop-types";

export class NavBar extends Component {

  static get propTypes(){
    return {
      config: PropTypes.object.isRequired,
      customUtility: PropTypes.oneOfType([
        PropTypes.array,
        PropTypes.element
      ]),
      autoUtility: PropTypes.oneOfType([
        PropTypes.array,
        PropTypes.element
      ]),
    }
  }

  createLinkContainer(c, i){
    return (
      <LinkContainer key={i} to={c.link} activeHref="active">
        <NavItem>{c.title}</NavItem>
      </LinkContainer>
    )
  }
  createIndexContainer(c, i){
    return (
      <IndexLinkContainer key={i} to={c.link} activeHref="active">
        <NavItem>{c.title}</NavItem>
      </IndexLinkContainer>
    )
  }

  render() {
    let titleSrc = this.props.config.titleSrc;
    let categories = this.props.config.categories;

    let categoryComponents = categories.map((c, i) => {
      return (i === 0) ? this.createIndexContainer(c ,i) : this.createLinkContainer(c, i);
    });

    // Navbar Utility cases, users can add custom element or a list element pre-configured
    let utility = null;
    if(this.props.customUtility !== undefined){
      utility = this.props.customUtility;
    }
    else if(this.props.autoUtility !== undefined){
      utility =[
        <button key={0} type="button" className="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse-1">
          <span className="sr-only">Toggle navigation</span>
          <span className="icon-bar"/>
          <span className="icon-bar"/>
          <span className="icon-bar"/>
        </button>,
        <div key={1} className="collapse navbar-collapse navbar-collapse-1">
          <ul className="nav navbar-nav navbar-utility">
            {this.props.autoUtility}
          </ul>
        </div>
      ]
    }

    let title = null;
    let useImage = titleSrc.useImage;
    if(useImage === undefined || useImage === false)
      if (titleSrc.title !== undefined)
        title = titleSrc.title;
      else
        title = <label>{titleSrc.alt}</label>;
    else
      title = <img src={titleSrc.path} alt={titleSrc.alt}/>;


    return (
      <Navbar className="navbar navbar-default navbar-pf" role="navigation">
        <Navbar.Header>
          <Navbar.Toggle/>
          <Link className="navbar-brand" to="/">
            {title}
          </Link>
        </Navbar.Header>
        {utility}
        <Navbar.Collapse>
          <Nav className="navbar-nav navbar-primary" >
            {categoryComponents}
          </Nav>
        </Navbar.Collapse>
      </Navbar>
    );
  }
}

export default NavBar;
