import React, {Component} from 'react';
class Home extends Component {
    render() {
	    return (
		<div className="row ">
	           <div className="medium-12 columns">
                <div class="page-content">

        <div class="wizard-heading"> Book Event </div>
        
        <div class="wizard-v6-content">
            <div class="wizard-form">
                <form class="form-register" id="form-register" action="#" method="post">
                    <div id="form-total">


                        <h2>
                            <p class="step-icon"><span>1</span></p>
                            <span class="step-text"></span>
                        </h2>
                        <form align="right" name="form1" method="post" action="#">
  <label class="logoutLblPos">
  <input name="submit2" type="submit" id="submit2" value="Logout" />
  </label>
</form>
                        <section>
                            <div class="inner">
                                <div class="form-heading">
                                    <h3></h3>
                                    <span>1/2</span>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="eventName" name="eventName" required />
<span class="label">Name:Engagement Event</span>
</label>
                                    </div>
                                    <div class="form-holder">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantName" name="applicantName" required />
<span class="label">Enter applicant name</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantMobileNo" name="applicantMobileNo" required />
<span class="label">Enter applicant mobile number</span>
</label>
                                    </div>
                                    <div class="form-holder">
                                        <label class="form-row-inner">
<input type="text" name="applicantEmailId" id="applicantEmailId" class="form-control" required />
<span class="label">Enter applicant email ID</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantAddress" name="applicantAddress" required />
<span class="label">Enter applicant address</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantAddress" name="applicantAddress" required />
<span class="label">Enter the number of people</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantAddress" name="applicantAddress" required />
<span class="label">Enter Event Address</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder">
                                        <label for="day" class="special-label-1">Enter date of the event</label>
                                        <input type="text" name="day" class="day" id="day" placeholder="31 / 04 / 2022" />
                                    </div>
                                    
                                    <div class="form-holder">
                                        <label for="appt" class="special-label-1">Enter the time of the event </label>
                                        <input type="time" id="eventTime" name="eventTime"
       min="09:00" max="18:00" required />
                                        
                                    </div>
                                </div>
                                
                                
                                
                            </div>
                        </section>

                        <h2>
                            <p class="step-icon"><span>2</span></p>
                            <span class="step-text"></span>
                        </h2>
                        
                        <section>
                            <div class="inner">
                                <div class="form-heading">
                                    <h3>Food Type</h3>
                                    <span>2/2</span>
                                </div>
                                
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label for="room" class="special-label-1">Select the category </label>
                                        <select name="room" id="room" class="form-control">
<option value="Daily Design Metting - Metting Room No.1" selected>Deserts</option>
<option value="Single">Non-Vegetarian</option>
<option value="Double">Vegetarian</option>
</select>
                                        <span class="select-btn">
<i class="zmdi zmdi-chevron-down"></i>
</span>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantAddress" name="applicantAddress" required />
<span class="label">Enter Quantity of Veg items(In Numbers)</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label class="form-row-inner">
<input type="text" class="form-control" id="applicantAddress" name="applicantAddress" required />
<span class="label">Enter Quantity of Non Veg items(In Numbers)</span>
</label>
                                    </div>
                                </div>
                                <div class="form-row">
                                    <div class="form-holder form-holder-2">
                                        <label for="room" class="special-label-1">Select Add ons </label>
                                        <select name="room" id="room" class="form-control">
<option value="mshow" selected>Magic Show   &nbsp;3500</option>
<option value="Single">DJ Party  &nbsp;  2500</option>
<option value="Double">Mehandi   &nbsp;2500</option>
<option value="Double">Game Show &nbsp;  2500</option>
</select>
                                        <span class="select-btn">
<i class="zmdi zmdi-chevron-down"></i>
</span>
                                    </div>
                                </div>

                                
                            </div>
                        </section>
                    </div>
                </form>
            </div>
        </div>
    </div>

                </div>
                </div>  
	     );
    }
}
export default Home;