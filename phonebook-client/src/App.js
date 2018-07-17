import React, { Component } from 'react';
import { connect } from 'react-redux';
import * as contactAction from './actions/contactAction';
import ContactList from './components/ContactList';

class App extends Component {

  constructor(props){
    super(props);
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
    this.state = {
      firstName: ''
    }
  }

  handleChange(e){
    this.setState({
      firstName: e.target.value
    })
  }

  handleSubmit(e){
    e.preventDefault();
    let contact = {
      firstName: this.state.firstName
    }
    this.props.createContact(contact);
  }

  render() {
    return(
      <section className="container"> 
        <h1>PhoneBook Challenge</h1>
        <hr />
        <div>
          <h3>Add Contact</h3>
          <form onSubmit={this.handleSubmit}>
            <input type="text" onChange={this.handleChange} />
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
    createContact: contact => dispatch(contactAction.createContact(contact))
  }
};

export default connect(mapStateToProps, mapDispatchToProps)(App);