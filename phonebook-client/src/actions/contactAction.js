import * as actionTypes from './actionTypes';

export const fetchCreateContactSuccess = contact => ({
    type: actionTypes.CREATE_NEW_CONTACT,
    contact: contact
});

export const createContact = (contact) => {
    return dispatch => {
      dispatch(fetchContactsBegin());
      return fetch("http://localhost:3000/api/contact/", {
        method: 'POST',
        headers: {
          'Accept': 'application/json',
          'Content-Type': 'application/json'
        },
        body: JSON.stringify(contact)
        })
        .then(handleErrors)
        .then(res => {
          console.log(res);
          dispatch(fetchCreateContactSuccess(contact));
          return res;
        })
        .catch(error => dispatch(fetchContactsError(error)));
    };
};

export const filterContacts = (searchValue) => {
  return {
    type: actionTypes.FILTER_CONTACTS,
    searchValue: searchValue
  }
};

export const fetchContactsBegin = () => ({
  type: actionTypes.FETCH_CONTACTS_BEGIN
});

export const fetchContactsSuccess = contacts => ({
  type: actionTypes.FETCH_CONTACTS_SUCCESS,
  payload: { contacts }
});

export const fetchContactsError = error => ({
  type: actionTypes.FETCH_CONTACTS_FAILURE,
  payload: { error }
});

export function fetchContacts() {
    let header = new Headers({
        'Access-Control-Allow-Origin':'*',
        'Content-Type': 'multipart/form-data'
    });
    let sendData = {
        mode: 'cors',
        header: header
    };
    return dispatch => {
      dispatch(fetchContactsBegin());
      return fetch("http://localhost:3000/api/contact/", sendData)
        .then(handleErrors)
        .then(res => res.json())
        .then(json => {
          console.log(json);
          dispatch(fetchContactsSuccess(json));
          return json;
        })
        .catch(error => dispatch(fetchContactsError(error)));
    };
}
  
function handleErrors(response) {
    if (!response.ok) {
        console.error(response);
        throw Error(response.statusText);
    }
    return response;
}