'use strict';

const e = React.createElement;
function SkillItem(props){
    const splits = props.data.type.split('-');
    return (
        <div className="mb-3"><span className="fw-bolder">{props.data.name}</span>
            <div className="progress my-2 rounded" style={{height: "20px"}}>
                <div className="progress-bar bg-info" role="progressbar" data-aos="zoom-in-right" data-aos-delay="100" data-aos-anchor=".skills-section" style={{width: splits[1] + '%'}} aria-valuenow="95" aria-valuemin="0" aria-valuemax="100">{splits[0]}</div>
            </div>
        </div>
    );
}

class SkillBlock extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isLoaded: false};
    }

    componentDidMount() {
        fetch("/api/v1/skills")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    items: json,
                    isLoaded: true
                })
            })
    }

    render() {
        if(!this.state.isLoaded){
            return <div>Loading</div>
        }
        if(this.state.items.length == 0){
            return <div>No Skills</div>
        }
        const skills = this.state.items.map(item => <SkillItem key={item.id} data={item} />);
        console.log(skills);
        return (
            <div>{skills}</div>
        );
    }
}

const domContainer = document.querySelector("#skillItems");
const root = ReactDOM.createRoot(domContainer);
root.render(<SkillBlock />);