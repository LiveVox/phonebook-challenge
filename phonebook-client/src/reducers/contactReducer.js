import * as actionTypes from '../actions/actionTypes';

const initialState = {
    items: [],
    loading: false,
    error: null
};

// export default function productReducer(state = initialState, action) {
export default (state = initialState, action) => {
    switch (action.type){
        case actionTypes.CREATE_NEW_CONTACT:
            return {
                items: [...state.items, Object.assign({}, action.contact)],
                loading: false,
                error: null
            };

        case actionTypes.FETCH_CONTACTS_BEGIN:
            return {
              ...state,
              loading: true,
              error: null
            };
      
        case actionTypes.FETCH_CONTACTS_SUCCESS:
            return {
              ...state,
              loading: false,
              items: action.payload.contacts
            };

        case actionTypes.FETCH_CONTACTS_FAILURE:
            console.error(action);
            console.error(action.payload);
            console.error(action.payload.error);
            return {
              ...state,
              loading: false,
              error: action.payload.error,
              items: []
            };
        default:
            return state;
    }
};
