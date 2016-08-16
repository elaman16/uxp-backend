import React, {Component} from 'react';

export default class InviteDashBoard extends Component {
	constructor() {
		super();
		
		this.state = {
			invites: []	
		}
	}
	componentWillMount() {
		$.get('/user/invitations/list').then((data) => {
			this.renderInvites(data);
		});
	}
	renderInvites(inviteReqs) {
		var inviteTextBox = {
				flex: 1,
				display: 'flex',
				textAlign: 'center',
				justifyContent: 'space-around',
				alignItems: 'center',
				height: '60px'
		}
		if(inviteReqs.length > 0 && inviteReqs instanceof Array) {
			var renderedInvites = inviteReqs.map((invite, idx) => {
				return (
					<div key={invite.timeStamp} style={{backgroundColor: idx % 2 == 0 ? '#fff' : '#eee', display: 'flex', flexDirection: 'row', width: '100%', height: '60px'}}>
						<div style={inviteTextBox}>
							<p>{invite.name}</p>
						</div>
						<div style={inviteTextBox}>
							<p>{invite.email}</p>
						</div>
						<div style={inviteTextBox}>
							<p>{invite.company}</p>
						</div>
						<div style={inviteTextBox}>
							<p>{invite.timeStamp}</p>
						</div>
						<div style={inviteTextBox}>
							
							<span style={{margin: '10px', color: 'green', fontSize: '25px'}} className='fa fa-check'></span>
							<span style={{margin: '10px', color: 'red', fontSize: '25px'}} className='fa fa-close'></span>
						
						</div>
					</div>
				);
			})
			renderedInvites.unshift((
					<div style={{display: 'flex', flexDirection: 'row', width: '100%', height: '60px'}}>
					<div style={inviteTextBox}>
						<p>Name:</p>
					</div>
					<div style={inviteTextBox}>
						<p>Email:</p>
					</div>
					<div style={inviteTextBox}>
						<p>Company:</p>
					</div>
					<div style={inviteTextBox}>
						<p>Time:</p>
					</div>
					<div style={inviteTextBox}>
						<p>Approval:</p>
					</div>
				</div>
			))
			this.setState({
				invites: renderedInvites
			});
		}
	}
	render() {
	
		return (
			<div>
				{this.state.invites}
			</div>
		);
	}
}