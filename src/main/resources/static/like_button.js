'use strict';

const e = React.createElement;

class LikeButton extends React.Component {
    constructor(props) {
        super(props);
        this.state = {liked: false};
    }

    componentDidMount() {
        fetch("/api/v1/skills")
            .then((res) => res.json())
            .then((json) => {
                this.setState({
                    items: json
                })
            })
    }

    render() {
        if (this.state.liked) {
            return this.state.items[0].name;
        }

        return e(
            'button',
            {onClick: () => this.setState({liked: true})},
            'Like'
        );
    }
}

const domContainer = document.querySelector('#like_button_container');
const root = ReactDOM.createRoot(domContainer);
root.render(e(LikeButton));