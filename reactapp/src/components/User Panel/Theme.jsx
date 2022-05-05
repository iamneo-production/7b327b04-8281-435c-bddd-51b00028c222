import React, { Component } from 'react'
import ThemeService from '../../services/ThemeService'

class Theme extends Component {
    constructor(props) {
        super(props)

        this.state = {
                themes: []
        }
      
      
    }
    componentDidMount(){
      ThemeService.getTheme().then((res) => {
           this.setState({ themes: res.data});
       });
   }
    
 
   
   
  render() {
    return (
        <div className="container-lg">
        <h2 className="text-center" style={{"fontFamily":"fantasy"}}>Theme Listing </h2>
        <hr/>
        <div className='row'>

          {
            this.state.themes.map(
              theme=>
              <div className='col'>
              <div className="card" style={{width: "18rem"}}>
            
                   
              <div class="card-body" key={theme.id}>
              <img class="card-img-top" src={theme.url} style={{height:"200px",width:"230px"}} alt="Card image cap"/>
              <br />
              <br />
              <h6 class="card-title" style={{"fontFamily":"monospace"}}><p>Name:&nbsp;&nbsp;{theme.themename}</p></h6>
              <h6 class="card-title"  style={{"fontFamily":"monospace"}}><p>Description:&nbsp;&nbsp;{theme.description}</p></h6>
              <h6 class="card-title"  style={{"fontFamily":"monospace"}}><p>Videographer:&nbsp;&nbsp;{theme.videodetails}</p></h6>
              <h6 class="card-title" style={{"fontFamily":"monospace"}}><p>Photographer:&nbsp;&nbsp;{theme.photodetails}</p></h6>
              <h6 class="card-title"  style={{"fontFamily":"monospace"}}><p>Reyurn Gift:&nbsp;&nbsp;{theme.returngift}</p></h6>
              <h6 class="card-title"  style={{"fontFamily":"monospace"}}><p>Cost:&nbsp;&nbsp;{theme.cost}</p></h6>
              
              <button className='btn btn-primary'>Book Event</button>
            
              </div>
             
      
      </div>
      <br />
      </div>

            )
          }


        
        </div>
       
        
        
        
       


</div>
        
    );
  }
}
export default Theme;
