import "./App.css";
import { BrowserRouter as Router, Route, Switch } from 'react-router-dom';

import Header from "./Components/Header";
import Footer from "./Components/Footer";
import Home from "./General/Home/Home";
import About from "./General/About/About";
import Contact from "./General/Contact/Contact";
import Login from "./General/Login/Login";
import ResetPassword from "./General/Login/ResetPassword";
import Profile from "./General/Profile/Profile";
import Signup from "./UserUI/Signup/Signup";
import UpdateProfile from "./General/UpdateProfile/UpdateProfile";
import AddTheme from "./AdminUI/AddTheme/AddTheme";
import UpdateTheme from "./AdminUI/UpdateTheme/UpdateTheme";
import ManageTheme from "./AdminUI/ManageTheme/ManageTheme";
import AddFood from "./AdminUI/AddFood/AddFood";
import ManageFood from "./AdminUI/ManageFood/ManageFood";
import UpdateFood from "./AdminUI/UpdateFood/UpdateFood";
import AddAddon from "./AdminUI/AddAddon/AddAddon";
import ManageAddon from "./AdminUI/ManageAddon/ManageAddon";
import UpdateAddon from "./AdminUI/UpdateAddon/UpdateAddon";
import UpdateUsers from "./AdminUI/UpdateUser/UpdateUser";
import ManageUsers from "./AdminUI/ManageUsers/ManageUsers";
import AddBankDetails from "./UserUI/AddBankDetails/AddBankDetails";
import ViewBankDetails from "./UserUI/ViewBankDetails/ViewBankDetails";
import ViewThemes from "./UserUI/ViewThemes/ViewThemes";
import ViewFoods from "./UserUI/ViewFoods/ViewFoods";
import ViewAddons from "./UserUI/ViewAddons/ViewAddon";
import AddEvent from "./UserUI/AddEvent/AddEvent";
import EventDetails from "./UserUI/EventDetails/EventDetails"
import InvitationCard from "./General/InvitationCard/InvitationCard";
import MyEvents from "./UserUI/MyEvents/MyEvents";
import UnAuthorized from "./General/Errors/401";
import Forbidden from "./General/Errors/403";
import NotFound from "./General/Errors/404";

function App() {
  return (
    <div>
      <Header />
      <Router>
        <Switch>
          <Route exact path='/' component={Home}></Route>
          <Route exact path='/about' component={About}></Route>
          <Route exact path='/contact' component={Contact}></Route>
          <Route exact path='/login' component={Login}></Route>
          <Route exact path='/resetpassword' component={ResetPassword}></Route>
          <Route exact path='/signup' component={Signup}></Route>
          <Route exact path='/profile' component={Profile}></Route>
          <Route exact path='/updateprofile/:uId' component={UpdateProfile}></Route>

          <Route exact path='/addtheme' component={AddTheme}></Route>
          <Route exact path='/updatetheme/:tId' component={UpdateTheme}></Route>
          <Route exact path='/managetheme' component={ManageTheme}></Route>

          <Route exact path='/addfood' component={AddFood}></Route>
          <Route exact path='/updatefood/:fId' component={UpdateFood}></Route>
          <Route exact path='/managefood' component={ManageFood}></Route>

          <Route exact path='/addaddon' component={AddAddon}></Route>
          <Route exact path='/updateaddon/:aId' component={UpdateAddon}></Route>
          <Route exact path='/manageaddon' component={ManageAddon}></Route>

          <Route exact path='/updateuser/:uId' component={UpdateUsers}></Route>
          <Route exact path='/manageusers' component={ManageUsers}></Route>

          <Route exact path='/viewthemes' component={ViewThemes}></Route>
          <Route exact path='/viewfoods' component={ViewFoods}></Route>
          <Route exact path='/viewaddons' component={ViewAddons}></Route>

          <Route exact path='/addevent' component={AddEvent}></Route>
          <Route exact path='/myevents' component={MyEvents}></Route>
          <Route exact path='/viewcard' component={InvitationCard}></Route>

          <Route exact path='/addbankdetails' component={AddBankDetails}></Route>
          <Route exact path='/viewbankdetails' component={ViewBankDetails}></Route>
          <Route exact path='/eventdetails/:eId' component={EventDetails}></Route>

          <Route exact path='/unauthorized' component={UnAuthorized}></Route>
          <Route exact path='/forbidden' component={Forbidden}></Route>
          <Route component={NotFound}></Route>

        </Switch>
      </Router>
      <Footer />

    </div>
  );
}

export default App;
