# Features:
- Standard account registration and login, optionally common third party accounts may be used, e.g. Google, Microsoft, etc.  You should have previous experience if you wish to use third party authentication.
- Admin role can upgrade accounts for staff.
- Accept details of devices and identify whether they are ‘current’ (currently popular), ‘recycle’, ‘rare’ or ‘unknown’.
- Current devices will have listings for expected value according to third parties, such as CeX, etc. with a focus on local places to trade in by physically - handing in.  Owner to be given a QRCode that offers a bonus (e.g. voucher) which also identifies the eWaste Hub for a (potential) referral fee and simplifies them handing in a device (since they will have entered data already).  Data wiping is guaranteed by the third party.
- ‘Recycle’ devices are offered for recycling with data retrieval (at a fee) and data wiping (at no cost).  Data retrieval devices are accepted by the eWaste Hub themselves for retrieving data which is then hosted in the cloud and a secure link emailed to the owner for a limited time (valid for 3 months, can be retrieved from 3-6 months with a further fee payment, then deleted).  Data wiping will be handled by a third party who recycle the device.
- Rare devices are handled in a similar manner to current devices but the third parties may include eBay, etc.
- Unknown devices are flagged for employees to update the device database and contact the owner.
- Expected roles will include (device) owner, admin and staff (employee).
- For staff, creation of (new) devices details.  This should be initially populated from an offered device (by an owner).  Draft details should be saved (but not visible).
- Devices can be made visible or hidden, e.g. in case of incomplete/incorrect details.
- Devices can be moved between classifications, which include current/recycle/rare/unwanted as well as device types, i.e. console/phone/tablet/laptop, etc.  At least two device types should be shown working.
- When a device is current, details for at least one third party should be shown, e.g. in a new/pop out window.
- Payments for data transfer should be via paypal and stripe (sandbox only).
- An Admin dashboard will need to be available for managing users accounts.
- Relevant reports should be available for staff, e.g. payments for data wiping, device processing (e.g. received, transferring, wiping, dispatch to this party), QR Code generation by third party, referral fees.

(Goals)
Why would user use our system for e-waste mgmt ->
Hub to find local shops to sell devices(newish) physically, extra money, ethical recycling, data can be wiped/retrieved

(Methods)
3rd party buyers for newish/ ‘current’ devices,
3rd party recycling companies for ‘recycle’ devices,
rare devices -> Will have same offerings as current devices but also show ebay listings,
unknown devices -> Flag staff to update db and contact owner, data retrieval by eWaste Hub and data wiping by 3rd party recycling companies

(Steps)
- List 3rd party buyers for ‘current’ devices and ‘rare’ devices
- List ebay offering for ‘rare’ devices
- List 3rd party recycling companies for ‘recycle’ devices
- Flag the staff for unknown devices to enter the device details as well as contact owner
- Data retrieval process by eWaste Hub, data collected hosted on cloud for 3 months. Additionally, owners can access data from 3-6 months by paying fees. Data gets deleted after 6 months.
- Data wiping done by the 3rd part recycling companies.

## Questions:
- Devices (drop down or text box)
- Rare devices (checkbox - Special edition, field to add evidence?)
- Login page (separate login or same login for user and admin).
- Roles for staff (specific window access for staff).
- Device Identification.
- an api to call CeX or use dummy data?
    - CeX API - https://github.com/Dionakra/webuy-api
- QR code (Use and functionality)
- Where to store retrieved data from the device.?
- Regarding unknown devices.
- Feature 09 (visibility of new device details?)
- Feature 14 (statistics of users? And how do we manage user accounts )
- Feature 15 (functionalities for staff and admin)

---

# User Types:
- Owner (of Device)
- Admin
- Staff (Employee).

---

# User Stories:
## Admininstrator:
| Priority    | As a/an     | I want (to) | So that (I can) |
| ----------- | ----------- | ----------- | --------------- |
| Must Have   | System Admin| Have a dashboard| manage user accounts|
| Must Have   | System Admin| upgrade user accounts for staff to manage day-to-day needed activities| Upkeep the eWaste hub|

### Open Questions:
- If logging in, are they doing it from the same portal as the user log in from?
- Can the admin see the same functionalities as the staff?
    - Should we add more functionalities in the same page for staff.

## Staff:
| Priority    | As a/an     | I want (to) | So that (I can) |
| ----------- | ----------- | ----------- | --------------- |
| Must Have   | Staff       | Have functionality to see all flagged unknown devices| View unknown device details in a form format.|
| Must Have   | Staff       | Create new device details into system| Verify the unknown device details and allow other users to use that device.|
| Must Have   | Staff       | Be able to set a product as visible or hidden| Verify the product’s detail|
| Must Have   | Staff       | Be able to move device’s classification or type| No wrong information is present for any device.|
| Should Have | Staff       | Be able to retrieve user data and host it on cloud | Send secure link emailed to the owner for a limited time|
| Could Have  | Staff       | Accept qr code from user that works as a voucher| Identify potential referral fees as well as simplify handing the device.|
| Should Have | Staff       | Have relevant reports| Be able to process devices|
| Must Have   | Staff       | See payments for data wiping orders.| So that I can process the device further|
| Must Have   | Staff       | Process devices (e.g. received, transferring, wiping, dispatch to this party)| Fulfil the order|
| Should Have | Staff       | Be able to generate QR Code by third party | Share it with device owners for their orders|

### Open Questions:
- 7th and 9th point connected or not - discuss our understanding.
- Hidden for unknown devices initially set or not?
- At least two device types should be shown working.
    - What does this mean
    - Is it two device types are visible for user to choose from or something else?
- QR Code generation by third party??
    - Does this mean that CeX will provide us with QR code to be shared with users? (After the user adds their device details, do we as mgmt facilitate this and provide details to CeX and once they have processed on their end provide the QR code back to the user?)
    - QRCode that offers a bonus (e.g. voucher)- is it the same?


## Owner(of device):
| Priority    | As a/an        | I want (to) | So that (I can) |
| ----------- | -------------- | ----------- | --------------- |
| Must Have   |Owner(of device)| Have login/registration portal | Login/register into the web application|
| Could have |Owner(of device)| Have functionality of forget password | Reset my password|
| Must Have   |Owner(of device)| Enter details about my device | Either recycle, trade-in, exchange my device|
| Must have   |Owner(of device)| Retrieve data and wipe device after recycle| Be able to see memories/collection for sentimental reasons|
| Must Have   |Owner(of device)| Be able to pay for data retrieval | Have easy online payment system( paypal and stripe)|
| Must Have   |Owner(of device)| Get listings for current device where I can sell device (At Least one redirection)| Trade in or get better value for newish devices|
| Should Have |Owner(of device)| Also get listings for rare devices (from ebay) | Help maintain the rare devices so that they are not recycled (sentimental value)|
| Could have  |Owner(of device)| Be able to have QR code for my order (to trade in device) | Simplify handing in my device|

### Open Questions:
- currently popular?
    - (Either decided by staff based on release date,)
    - Based on how many devices of that type have been exchanged.

- Rare device -> justification? How are we assuming that device is rare
    - Limited edition - Is staff checking these as well?
- with a focus on local places to trade in physically?
    - Listing are from CeX (that shows physical stores where user can trade-in their devices)
- referral fee and simplifies them handing in a device?
- hosted in the cloud and a secure link emailed to the owner for a limited time (valid for 3 months, can be retrieved from 3-6 months with a further fee payment, then deleted).?
    - Do we need to host the data on the cloud?

---

# Skills Choices:
- **Database** : SQL
- **Server** : Springboot
- **Front end/GUI** : React
