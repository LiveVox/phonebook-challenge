import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as contactAction from './actions/contactAction';
import ContactList from './components/ContactList';

class App extends Component {

  constructor(props){
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.handleChangeSearch = this.handleChangeSearch.bind(this);
    this.state = {
      firstName: ''
    }
  }

  handleChangeSearch(e){
    let searchValue = e.target.value;
    this.props.filterContacts(searchValue);
  }

  handleChange(e){
    let change = {};
    change[e.target.name] = e.target.value;
    this.setState(change);
  }

  handleSubmit(e){
    e.preventDefault();
    let contact = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      phone: this.state.phone
    }
    this.props.createContact(contact);
  }

  render() {
    return(
  <div className="container">
		<div className="pure-g">
			<div className="pure-u-1">
				<div className="header">
					<img className="logo" src={require('./phonebook.png')}/>
					<p>v 1.0</p>
				</div>
				
			</div>
		</div>
		<div className="pure-g">
		    <div className="pure-u-sm-1 pure-u-1-3">
		    	<div className="box">
		    		<h2><i className="fa fa-user-plus"></i>New contact</h2>
		    		<form className="pure-form" onSubmit={this.handleSubmit}>
					    <fieldset className="pure-group">
					        <input type="text" className="pure-input-1-2" placeholder="First Name" name="firstName" onChange={this.handleChange.bind(this)} />
					        <input type="text" className="pure-input-1-2" placeholder="Last Name" name="lastName" onChange={this.handleChange.bind(this)} />
					        <input type="text" className="pure-input-1-2" placeholder="Phone" name="phone" onChange={this.handleChange.bind(this)} />
					    </fieldset>
					    <button type="submit" className="pure-button pure-input-1-2 pure-button-primary">
					    <i className="fa fa-user-plus"></i>Add</button>
					</form>
				</div>
			</div>
		    <div className="pure-u-sm-1 pure-u-1-3">
				<div className="box">
		    		<h2><i className="fa fa-search"></i>Search contact</h2>
		    		<form className="pure-form">
		    			<fieldset className="pure-group">
					    	<input type="text" className="pure-input-1-2" name="search" onChange={this.handleChangeSearch.bind(this)}/>
					     </fieldset>
					    <button type="submit" className="pure-button pure-input-1-2 pure-button-primary">
					    <i className="fa fa-search"></i>Search</button>
					</form>
				</div>
			</div>
			<div className="pure-u-sm-1 pure-u-1-3">
				<div className="box">
		    		<h2><i className="fa fa-users"></i> Contacts</h2>
            <ContactList />      
				</div>
			</div>
		</div>
	</div>


      
    )
  }
}

const mapStateToProps = (state, ownProps) => {
  console.log(state);
  return {
    contacts: state.contacts.items
  }
};

const mapDispatchToProps = (dispatch) => {
  return {
    createContact: contact => dispatch(contactAction.createContact(contact)),
    filterContacts: searchValue => dispatch(contactAction.filterContacts(searchValue))
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);