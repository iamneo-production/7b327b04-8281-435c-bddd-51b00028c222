import React, { Component } from 'react'
import ThemeService from '../../services/ThemeService'

class UpdateTheme extends Component {
    constructor(props) {
        super(props)

        this.state = {
            id: this.props.match.params.id,
            themename:'',
            url: '',
            photodetails: '',
            videodetails: '',
            returngift:'',
            cost:'',
            description:''
        }
        this.changeThemename=this.changeThemename.bind(this);
        this.changeUrl=this.changeUrl.bind(this);
        this.changePhoto=this.changePhoto.bind(this);
        this.changeVideo=this.changeVideo.bind(this);
        this.changeGift=this.changeGift.bind(this);
        this.changeCost=this.changeCost.bind(this);
        this.changeDescription=this.changeDescription.bind(this);
     
     
     
     
    }
    componentDidMount(){
        ThemeService.getThemeById(this.state.id).then( (res) =>{
            let theme = res.data;
            this.setState({themename: theme.themename,
                url:theme.url,
                photodetails:theme.photodetails,
                videodetails:theme.videodetails,
                returngift:theme.returngift,
                cost:theme.cost,
                description:theme.description,

                
            });
        });
    }
    UpdateTheme = (e) => {
        e.preventDefault();
        let theme= {themename: this.state.themename, url: this.state.url, photodetails: this.state.photodetails,videodetails:this.state.videodetails,returngift:this.state.returngift,cost:this.state.cost,description:this.state.description};
        console.log('theme => ' + JSON.stringify(theme));
        console.log('id => ' + JSON.stringify(this.state.id));
        ThemeService.updateTheme(theme, this.state.id).then( res => {
            this.props.history.push('/admin/themeList');
        });
  
        
    
    }
    changeThemename= (event) => {
        this.setState({themename: event.target.value});
    }
    changeUrl= (event) => {
        this.setState({url: event.target.value});
    }
    changePhoto=(event)=>
    {
        this.setState({photodetails: event.target.value});

    }
    changeVideo=(event)=>
    {
        this.setState({videodetails: event.target.value});

    }
    changeGift=(event)=>
    {
        this.setState({returngift: event.target.value});

    }
    changeCost=(event)=>
    {
        this.setState({cost: event.target.value});

    }
    changeDescription=(event)=>
    {
        this.setState({description: event.target.value});

    }
    cancel=(event)=>
    {
        this.props.history.push('/admin/themeList');
    }


    render() {
        return (
            <div>
            <div>
            <br></br>
               <div className = "container">
             <div className = "row">
                 
                        <div className = "card col-md-6 offset-md-3 offset-md-3">
                        
                            <div className = "card-body">
                            <h2 className="text-center">Add Themes</h2>
                            <br />
                    
                                <form>
                                    <div className = "form-group">
                                        <label> Theme Name </label>
                                        <input placeholder="Theme Name" name="themename" className="form-control" value={this.state.themename} onChange={this.changeThemename}
                                          />
                                    </div>
                                    <br />
                                    <div className = "form-group">
                                        <label> Theme Image </label>
                                        <input placeholder="Theme Image" name="url" className="form-control"  value={this.state.url} onChange={this.changeUrl}
                                          />
                                    </div>
                                    <br />
                                    <div className = "form-group">
                                        <label> Photographer Details</label>
                                        <input placeholder="Photographer Details" name="photodetails" className="form-control"   value={this.state.photodetails} onChange={this.changePhoto}
                                          />
                                    </div>
                                    <br />
                                    <div className = "form-group">
                                        <label>Videgrapher Details </label>
                                        <input placeholder="Videographer Details" name="videodetails" className="form-control"  value={this.state.videodetails} onChange={this.changeVideo}
                                          />
                                    </div>
                                    <br />
                                    <div className = "form-group">
                                        <label>Return Gifts </label>
                                        <input placeholder="Return Gifts" name="returngift" className="form-control"  value={this.state.returngift} onChange={this.changeGift}
                                          />
                                    </div>
                                    <br />
                                    <div className = "form-group">
                                        <label>Cost </label>
                                        <input placeholder="Cost" name="cost" className="form-control"  value={this.state.cost} onChange={this.changeCost}
                                          />
                                    </div>
                                    <br />
                                    <div className = "form-group">
                                        <label>Description  </label>
                                        <textarea placeholder="Description" name="description" className="form-control"  value={this.state.description} onChange={this.changeDescription}
                                          />
                                    </div>
                                    <br />
                                    <button className="btn btn-success" onClick={this.UpdateTheme} >Update</button>
                                    <button className="btn btn-danger" onClick={this.cancel} style={{marginLeft: "10px"}}>Cancel</button>

                                  
                                </form>
                            </div>
                        </div>
                    </div>

               </div>
        </div>
          
        </div>
          
        );
    }
}

export default UpdateTheme;