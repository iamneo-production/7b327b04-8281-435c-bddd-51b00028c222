import React ,{Component} from 'react';
class Footer extends React.Component
{
    render(){
        return (

            <footer class="footer widget-footer bg-img11 ttm-bgcolor-black ttm-bg ttm-bgimage-yes clearfix">
            <div class="ttm-row-wrapper-bg-layer ttm-bg-layer"></div>
            <div class="first-footer ttm-textcolor-white">
                <div class="container">
                    <div class="row">
                        <div class="widget-area col-xs-12 col-sm-12 col-md-12 col-lg-12">
                            <aside class="widget widget-text">
                                <div class="ttm-newstter-box">
                                    <h4>Subscribe to <span class="ttm-textcolor-skincolor">Our Newsletter</span></h4>
                                    <p>No spam message from us, only give you latest offer which is best for you and your business</p>
                                    <form class="mc4wp-form mc4wp-form-24" method="post" data-id="24" data-name="Newsletter Form">
                                        <div class="mc4wp-form-fields">
                                            <div class="mailchimp-inputbox">
                                                <input type="email" name="EMAIL" placeholder="Your email address.." required=""/>
                                                <input type="submit" value="Subscribe Now"/>
                                        </div>
                                        </div>
                                        <div class="mc4wp-response"></div>
                                    </form>
                                </div>
                            </aside>
                        </div>
                    </div>
                 
                </div>
            </div>
            <div class="container" id="sd"> 
            <div class="second-footer" >
                <div class="container">
                    <div class="second-footer-inner">
                        <div class="row">
                            <div class="widget-area col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="widget widget-out-link clearfix">
                                    <h4 class="widget-title">Contact Us</h4>
                                    <ul class="widget-contact">
                                        <li><i class="fa fa-map-marker"></i>Wedding Planners<br/>Virtusa</li>
                                        <li><i class="fa fa-envelope-o"></i><a href="#">weddingplanners@gmail.com</a></li>
                                        <li><i class="fa fa-phone"></i>Phone: (+01) 123 456 7890 <br/>Support: (+01) 123 456 7890 </li>
                                    </ul>
                                </div>
                            </div>
                            <div class="widget-area col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="widget widget_nav_menu clearfix">
                                    <h4 class="widget-title">Navigations</h4>
                                    <ul class="menu-footer-services">
                                        <li><a href="#">Home</a></li>
                                        <li><a href="#">Abouts Us</a></li>
                                        <li><a href="#">Services</a></li>
                                        <li><a href="#">Pricing</a></li>
                                        <li><a href="#">Login</a></li>
                                        <li><a href="#">Terms and Conditions</a></li>
                                    </ul>
                                </div>
                            </div>
                           <div class="widget-area col-xs-12 col-sm-6 col-md-6 col-lg-3">
                                <div class="widget widget-out-link clearfix ">
                                    <h4 class="widget-title">Frequent Questions</h4>
                                    <ul class="widget-text">
                                        <li><a href="#">How Can I Set An Event? </a></li>
                                        <li><a href="#">What Venues Do You Use? </a></li>
                                        <li><a href="#">Event Catalogue </a></li>
                                       
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
            <div class="bottom-footer-text">
                <div class="container">
                    <div class="row">
                        <div class="col-md-8 col-sm-12 col-xs-12 ttm-footer2-left">
                            <div class="company-info">
                                <div class="company-logo">
                                <h2 style={{color:'white'}}> Wedding Planners
                                      </h2>
                                </div>
                                <div class="company-desc">At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesue corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culp.
                                </div>
                            </div>
                        </div>
                        <div class="col-sm-12 col-xs-12 col-md-4 ttm-footer2-right">
                            <div class="ttm-social-link-wrapper">
                                <ul class="social-icons">
                                    <li><a href="#" target="_blank"><i class="fa fa-facebook"></i></a></li>
                                    <li><a href="#" target="_blank"><i class="fa fa-twitter"></i></a></li>
                                    <li><a href="#" target="_blank"><i class="fa fa-instagram"></i></a></li>
                                    <li><a href="#" target="_blank"><i class="fa fa-youtube-play"></i></a></li>
                                </ul>
                            </div>
                            <p>Copyright © 2022 Wedding Planners All rights reserved.</p>
                        </div>
                    </div>
                </div>
            </div>
        </footer>

        );
        }
}
export default Footer;
