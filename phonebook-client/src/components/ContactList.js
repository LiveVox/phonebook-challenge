import React from "react";
import { connect } from "react-redux";
import { fetchContacts } from "../actions/contactAction";

class ContactList extends React.Component {
  componentDidMount() {
    this.props.dispatch(fetchContacts());
  }

  render() {
    const { error, loading, contacts } = this.props;
    
    if (error) {
      return <div>Error! {error.message}</div>;
    }

    if (loading) {
      return <div>Loading...</div>;
    }

    return (
      <table>
        <thead>
          <tr>
            <th>Name</th>
            <th>Phone</th>
          </tr>
        </thead>
        <tbody>
          {contacts.map((contact, id) =>
            <tr key={id}>
              <td>{contact.firstName}</td>
              <td>{contact.phone}</td>
            </tr>
          )}
        </tbody>
      </table>
    );
  }
}

const mapStateToProps = state => ({
  contacts: state.contacts.items,
  loading: state.contacts.loading,
  error: state.contacts.error
});

export default connect(mapStateToProps)(ContactList);