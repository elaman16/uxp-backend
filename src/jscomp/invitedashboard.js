import React, {Component} from 'react';

export default class InviteDashBoard extends Component {
	constructor() {
		super();
		
		this.state = {
				
		}
	}
	componentWillMount() {
		$.get('/user/invitations/list').then((data) => {
			console.log(data);
		});
	}
	render() {
		return (
			<div>
				<h1>Invite Dash</h1>
			</div>
		);
	}
}