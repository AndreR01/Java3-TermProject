'use strict';

const e = React.createElement;

class EductationButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {liked: false};
    }

    componentDidMount() {
        fetch("/api/v1/educations")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    items: json
                })
            })
    }

    render() {
        if (this.state.liked) {
            return this.state.items[0].title;
        }

        return e(
            'button',
            {onClick: () => this.setState({liked: true})},
            'Education'
        );
    }
}

const domContainer = document.querySelector('#education_button_container');
const root = ReactDOM.createRoot(domContainer);
root.render(e(EductationButton));