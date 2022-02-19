import * as actionTypes from "../actions/actionTypes";
import { updateObject } from "../utility";

const initialState = {
  user: null,
  auth: false,
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case actionTypes.SET_USER:
      return updateObject(state, {
        user: action.data,
        auth: true,
      });
    case actionTypes.LOGOUT:
      return updateObject(state, {
        user: null,
        auth: false,
      });
    default:
      return state;
  }
};

export default reducer;
