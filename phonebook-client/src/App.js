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
    // let filteresContacts = this.props.contacts.filter(obj => Object.keys(obj).some(key => obj[key].includes(e.target.value)));
    // console.log(this.props);
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
      <section className="container"> 
        <h1>PhoneBook Challenge</h1>
        <hr />
        <div>
          <h3>Search</h3>
            <input type="text" name="search" onChange={this.handleChangeSearch.bind(this)} />
        </div>
        <div>
          <h3>Add Contact</h3>
          <form onSubmit={this.handleSubmit}>
            <input type="text" name="firstName" onChange={this.handleChange.bind(this)} />
            <input type="text" name="lastName" onChange={this.handleChange.bind(this)} />
            <input type="text" name="phone" onChange={this.handleChange.bind(this)} />
            <input type="submit" />
          </form>
        </div>
        <hr />
        <ContactList />
      </section>
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