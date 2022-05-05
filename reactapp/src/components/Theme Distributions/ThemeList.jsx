import React, { Component } from 'react'
import ThemeService from '../../services/ThemeService'

class ThemeList extends Component {
    constructor(props) {
        super(props)

        this.state = {
                themes: []
        }
        this.addTheme = this.addTheme.bind(this);
        this.editTheme = this.editTheme.bind(this);
        this.deleteTheme = this.deleteTheme.bind(this);
      
      
    }
    componentDidMount(){
       ThemeService.getTheme().then((res) => {
            this.setState({ themes: res.data});
        });
    }
    deleteTheme(id)
    {
        ThemeService.deleteTheme(id).then( res => {
            this.setState({themes: this.state.themes.filter(theme => theme.id !== id)});
        });

    }
    addTheme(){
        this.props.history.push('/admin/addTheme');
    }
    editTheme(id){
        this.props.history.push(`/admin/updateTheme/${id}`);
    }
  render() {
    return (
        <div className="container">
        <h2 className="text-center">List of Themes</h2>
        <div className = "row">
           <button className="btn btn-primary" onClick={this.addTheme} style={{width:"100px"}}> Add Theme</button>
        </div>
        <br></br>
        <div className = "row">
               <table className = "table table-striped table-dark table-hover">

                   <thead>
                       <tr>
                           <th>Theme Name</th>
                           <th>Theme Image</th>
                           <th>Photographer Details</th>
                           <th>Videographer Details</th>
                           <th>Gift Theme</th>
                           <th>Cost</th>
                           <th>Description</th>
                           <th>Actions</th>

                       </tr>
                   </thead>
                   <tbody>
                       {
                           this.state.themes.map(
                               theme => 
                               <tr key = {theme.id}>
                                   
                                    <td> {theme.themename}</td>
                                    <td> <img src={theme.url} style={{height:"190px",width:"190px"}}></img> </td>   
                                    <td> {theme.photodetails}</td>
                                    <td>{theme.videodetails}</td>
                                    <td>{theme.returngift}</td>
                                    <td>{theme.cost}</td>
                                    <td>{theme.description}</td>
                                  
                                    <td>
                                    <button  onClick={ () => this.editTheme(theme.id)} className="btn btn-info">Update </button>
                                    <br />
                                    <button  onClick={ () => this.deleteTheme(theme.id)} style={{marginLeft: "0px",width:"80px",marginTop:"20px"}}  className="btn btn-danger">Delete </button>
                                         <br />        
                                    </td>
                               </tr>
                           )
                       }
                   </tbody>
               </table>

        </div>

   </div>
    )
  }
}
export default ThemeList;
