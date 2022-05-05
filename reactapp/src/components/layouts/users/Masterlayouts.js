import React from "react";
import Navbar from './Navbars';
import Footer from './Footer';
import SideNavbar from './Sidebars';
import '../../assets/admin/css/styles.css';
import '../../assets/admin/js/scripts';
import routes from "../../routes/routes";
import {Switch,Route,Redirect} from 'react-router-dom';
const Masterlayout=()=>
{
    return(
        <div className="sb-nav-fixed">
            <Navbar/>
            <div id="layoutSidenav">
            <div id="layoutSidenav_nav">
                <SideNavbar/>


            </div>
            <div id="layoutSidenav_content">
           
                <main>
                <Switch>
                    {
                        routes.map((route,idx)=>{
                            return(
                                route.component && 
                                (
                                    <Route key={idx}
                                     path={route.path} 
                                     exact={route.exact}
                                     name={route.name}
                                     render={(props)=>(
                                         <route.component {...props}/>
                                     )
                                    }
                                     />
                                )

                            );

                        })
}
<Redirect from="user" to="/user/theme"></Redirect>
                    
                </Switch>
                    
                </main>
                <Footer/>
              
                
            </div>
            </div>


        </div>
        
    );

}
export default Masterlayout;