'use strict';

const e = React.createElement;
function WorkItem(props){
    return (
        <div className="timeline-card timeline-card-info" data-aos="fade-in" data-aos-delay="0">
            <div className="timeline-head px-4 pt-3">
                <div className="h5">{props.data.jobTitle} <span className="text-muted h6">at {props.data.company}</span></div>
                </div>
                <div className="timeline-body px-4 pb-4">
                <div className="text-muted text-small mb-3">Start Date: {props.data.startDate} - End Date: {props.data.endDate}</div>
                <div>{props.data.description}</div>
            </div>
        </div>
    );
}

class WorkBlock extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isLoaded: false};
    }

    componentDidMount() {
        fetch("/api/v1/experience")
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
            return <div>No Work</div>
        }
        const works = this.state.items.map(item => <WorkItem key={item.id} data={item} />);
        return (
            <div>{works}</div>
        );
    }
}

const domContainer = document.querySelector("#workItems");
const root = ReactDOM.createRoot(domContainer);
root.render(<WorkBlock />);