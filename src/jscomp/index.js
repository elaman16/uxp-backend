import React, {Component} from 'react';
import ReactDOM from 'react-dom';
import InviteDashBoard from './invitedashboard.js';
import HomeDashBoard from './homedashboard.js';
import ActivityDashBoard from './activitydashboard.js';
import BlockedDashBoard from './blockeddashboard.js';

var adminTools = {
		showInviteDash: function() {
			ReactDOM.unmountComponentAtNode(document.getElementById('adminContent'));
			ReactDOM.render(<InviteDashBoard />, document.getElementById("adminContent"));
		},
		showHomeDash: function() {
			ReactDOM.unmountComponentAtNode(document.getElementById('adminContent'));
			ReactDOM.render(<HomeDashBoard />, document.getElementById("adminContent"));
		},
		showActivityDash: function() {
			ReactDOM.unmountComponentAtNode(document.getElementById('adminContent'));
			ReactDOM.render(<ActivityDashBoard />, document.getElementById("adminContent"));
		},
		showBlockedDash: function() {
			ReactDOM.unmountComponentAtNode(document.getElementById('adminContent'));
			ReactDOM.render(<BlockedDashBoard />, document.getElementById("adminContent"));
		}
}
window.adminTools = adminTools;
