'use strict';

const e = React.createElement;
function EduItem(props){
    return (
        <div className="timeline-card timeline-card-success" data-aos="fade-in" data-aos-delay="{(props.data.id - 1) * 400}">
            <div className="timeline-head px-4 pt-3">
                <div className="h5">{props.data.title} <span className="text-muted h6">from {props.data.institutionName}</span>
                </div>
            </div>
            <div className="timeline-body px-4 pb-4">
                <div className="text-muted text-small mb-3">{props.data.startDate} - {props.data.endDate}
                </div>
                <div>{props.data.abbreviation}
                </div>
            </div>
        </div>
    );
}

class EducationBlock extends React.Component {
    constructor(props) {
        super(props);
        this.state = {isLoaded: false};
    }

    componentDidMount() {
        fetch("/api/v1/educations")
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
            return <div>No Education</div>
        }
        const edus = this.state.items.map(item => <EduItem key={item.id} data={item} />);
        return (
            <div>{edus}</div>
        );
    }
}

const domContainer = document.querySelector("#educationItems");
const root = ReactDOM.createRoot(domContainer);
root.render(<EducationBlock />);