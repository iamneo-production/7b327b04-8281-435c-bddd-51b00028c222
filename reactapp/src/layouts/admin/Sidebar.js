import React from "react";
import {Link} from 'react-router-dom';
const Sidebar=()=>
{
    return(
        <div>
             <nav className="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
                    <div className="sb-sidenav-menu">
                        <div className="nav">
                            <div className="sb-sidenav-menu-heading">Core</div>
                            <Link className="nav-link" to="/admin/foods">
                                <div className="sb-nav-link-icon"><i className="fas fa-tachometer-alt"></i></div>
                                Display Food List
                            </Link>
                            <Link className="nav-link" to="/admin/addFood">
                                <div className="sb-nav-link-icon"><i className="fas fa-tachometer-alt"></i></div>
                                Add Food
                            </Link>
                         
                           
                          
                            <div className="collapse" id="collapsePages" aria-labelledby="headingTwo" data-bs-parent="#sidenavAccordion">
                                <nav className="sb-sidenav-menu-nested nav accordion" id="sidenavAccordionPages">
                                   
                                    
                                    <Link className="nav-link collapsed" to="#" data-bs-toggle="collapse" data-bs-target="#pagesCollapseError" aria-expanded="false" aria-controls="pagesCollapseError">
                                        Error
                                        <div className="sb-sidenav-collapse-arrow"><i className="fas fa-angle-down"></i></div>
                                    </Link>
                                   
                                </nav>
                            </div>
                            <div className="sb-sidenav-menu-heading">Addons</div>
                            <Link className="nav-link" to="/admin/themeList">
                                <div className="sb-nav-link-icon"><i className="fas fa-chart-area"></i></div>
                             Display List Of Themes
                            </Link>
                            <Link className="nav-link" to="/admin/addTheme">
                                <div className="sb-nav-link-icon"><i className="fas fa-table"></i></div>
                                Add Themes
                            </Link>
                        </div>
                    </div>
                    <div className="sb-sidenav-footer">
                        <div className="small">Logged in as:</div>
                        Admin
                    </div>
                </nav>
           
        </div>
    );

}
export default Sidebar;