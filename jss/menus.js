/*
 * Ext JS Library 2.1
 * 
 */

Ext.onReady(function(){
    Ext.QuickTips.init();

    // Menus can be prebuilt and passed by reference
    var menuHome = new Ext.menu.Menu({
        id: 'menuHome',
         items: [
			{
                text: 'User Profile',
                menu: {        // <-- submenu by nested config object
                    items: [
						{
                           text: 'Edit',
                    	   handler: editUserProfile
                       },
                       {
                           text: 'Change Password',
                           href :'ChangePassword.do?operation=edit&pageOf=pageOfChangePassword'
                       }
                    ]
                }
            },
            {
           		text: 'Assign Privileges',
                href:'AssignPrivilegesPage.do?pageOf=pageOfAssignPrivilegesPage'
            }
        ]
    });

    var menu = new Ext.menu.Menu({
        id: 'mainMenu',
        items: [
            {
                text: 'User',
				href:'User.do?operation=add&pageOf=pageOfUserAdmin',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
							href:'User.do?operation=add&pageOf=pageOfUserAdmin'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfUserAdmin&aliasName=User' 
                        }, {
                            text: 'Approve New Users',
                            href:'ApproveUserShow.do?pageNum=1' 
	                       }
                    ]
                }
            },
				{
                text: 'Institution',
				href:'Institution.do?operation=add&pageOf=pageOfInstitution',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
							href:'Institution.do?operation=add&pageOf=pageOfInstitution'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfInstitution&aliasName=Institution' 
                        } 
                    ]
                }
            },
				{
                text: 'Department',
				href:'Department.do?operation=add&pageOf=pageOfDepartment',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
							href:'Department.do?operation=add&pageOf=pageOfDepartment'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfDepartment&aliasName=Department' 
                        } 
                    ]
                }
            },
				{
                text: 'Cancer Research Group',
				href:'CancerResearchGroup.do?operation=add&pageOf=pageOfCancerResearchGroup',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
							href:'CancerResearchGroup.do?operation=add&pageOf=pageOfCancerResearchGroup'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfCancerResearchGroup&aliasName=CancerResearchGroup' 
                        } 
                    ]
                }
            },
             
			  {
                text: 'Site',
				href:'Site.do?operation=add&pageOf=pageOfSite',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'Site.do?operation=add&pageOf=pageOfSite'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfSite&aliasName=Site' 
                        }
                    ]
                }
            },
			  {
                text: 'Storage Type',
				href:'StorageType.do?operation=add&pageOf=pageOfStorageType',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                             href:'StorageType.do?operation=add&pageOf=pageOfStorageType'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfStorageType&aliasName=StorageType' 
                        }
                    ]
                }
            },
			{
                text: 'Storage Container',
				href:'StorageContainer.do?operation=add&pageOf=pageOfStorageContainer',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'StorageContainer.do?operation=add&pageOf=pageOfStorageContainer'
                        }, {
                            text: 'Edit',
                             href:'SimpleQueryInterface.do?pageOf=pageOfStorageContainer&aliasName=StorageContainer'
                        }, {
                            text: 'View Map',
                            
                            handler: showStorageContainerMap
                        }
                    ]
                }
            },
			{
                text: 'Specimen Array Type',
				href:'SpecimenArrayType.do?operation=add&amp;pageOf=pageOfSpecimenArrayType',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'SpecimenArrayType.do?operation=add&amp;pageOf=pageOfSpecimenArrayType'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfSpecimenArrayType&aliasName=SpecimenArrayType' 
                        }
                    ]
                }
            },
			{
                text: 'Biohazard',
				href:'Biohazard.do?operation=add&pageOf=pageOfBioHazard',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'Biohazard.do?operation=add&pageOf=pageOfBioHazard'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfBioHazard&aliasName=Biohazard' 
                        }
                    ]
                }
            },
			{
                text: 'Collection Protocol',
				href:'CollectionProtocol.do?operation=add&pageOf=pageOfCollectionProtocol',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'CollectionProtocol.do?operation=add&pageOf=pageOfCollectionProtocol'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfCollectionProtocol&aliasName=CollectionProtocol' 
                        }
                    ]
                }
            },
			{
                text: 'Distribution Protocol',
				href:'DistributionProtocol.do?operation=add&pageOf=pageOfDistributionProtocol',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'DistributionProtocol.do?operation=add&pageOf=pageOfDistributionProtocol'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfDistributionProtocol&aliasName=DistributionProtocol' 
                        }
                    ]
                }
            },
			{
                text: 'Reported Problems',
                href:'ReportedProblemShow.do?pageNum=1'
            },
			{
                text: 'Local Extensions',
                href:'DefineAnnotationsInformationPage.do'
            },
			{
                text: 'Conflicting Reports',
                href:'ConflictView.do?pageNum=1'
            }
			
		]
    });
            // For Bio Specimen Data

    var menu_bio = new Ext.menu.Menu({
        id: 'menu_bio',
        items: [
            {
                text: 'Collection Protocol Based View',
                href:'CpBasedSearch.do'

            },
			{
                text: 'Participant',
				href:'Participant.do?operation=add&pageOf=pageOfParticipant&clearConsentSession=true',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'Participant.do?operation=add&pageOf=pageOfParticipant&clearConsentSession=true'
                        }, {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfParticipant&aliasName=Participant'
                        }
                    ]
                }
            },
              {
                text: 'Specimen',
				href:'SimpleQueryInterface.do?pageOf=pageOfNewSpecimen&aliasName=Specimen',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                        {
                            text: 'Edit',
                            href:'SimpleQueryInterface.do?pageOf=pageOfNewSpecimen&aliasName=Specimen'
                        }, {
                            text: 'Derive',
                            href:'CreateSpecimen.do?operation=add&amp;pageOf=&virtualLocated=true'
                        }, {
                            text: 'Aliquot',
                            href:'Aliquots.do?pageOf=pageOfAliquot'
                        }, {
                            text: 'Events',
                            href:'QuickEvents.do?operation=add'
                        }, {
                            text: 'Multiple',
                             href:'MultipleSpecimenFlexInitAction.do?pageOf=pageOfMultipleSpWithMenu'
                        }
                    ]
                }
            },
            {
                text: 'Specimen Array',
				href:'SpecimenArray.do?operation=add&amp;pageOf=pageOfSpecimenArray',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Add',
                            href:'SpecimenArray.do?operation=add&amp;pageOf=pageOfSpecimenArray'
                        }, {
                            text: 'Edit',
                             href:'SimpleQueryInterface.do?pageOf=pageOfSpecimenArray&aliasName=SpecimenArray'
                        }, {
                            text: 'Aliquot',
                            href:'SpecimenArrayAliquots.do?pageOf=pageOfSpecimenArrayAliquot'
                        }
                    ]
                }
            }, 
			  {
                text: 'Distribution',
				href:'SimpleQueryInterface.do?pageOf=pageOfDistribution&aliasName=Distribution',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Specimen Report',
                            href:'SimpleQueryInterface.do?pageOf=pageOfDistribution&aliasName=Distribution'
                        }, {
                            text: 'Array Report',
                            href:'SimpleQueryInterface.do?pageOf=pageOfArrayDistribution&aliasName=Distribution_array'
                        }
                    ]
                }
            },

                                      {

                            text: 'Order View',
		                    href:'RequestListView.do?pageNum=1'

            }
        ]
    });
            // For Search link

    var menu_search = new Ext.menu.Menu({
        id: 'menu_search',
        items: [
			{
                text: 'Saved Queries',
			    href : 'RetrieveQueryAction.do'                       
            },
            {
                text: 'Search',
				href:'SimpleQueryInterface.do?pageOf=pageOfSimpleQueryInterface',
                menu: {        // <-- submenu by nested config object
                    items: [
                        // stick any markup in a menu
                       {
                            text: 'Simple',
                            href:'SimpleQueryInterface.do?pageOf=pageOfSimpleQueryInterface'
                        }, {
                            text: 'Advanced',
						    href : 'QueryWizard.do?'
                           }
                    ]
                }
            },

              {

                text: 'My List View',
                href:'QueryAddToCart.do?operation=view'

                

            }

        ]

    });

    var tb = new Ext.Toolbar();
    tb.render('toolbarLoggedIn');
        
	tb.add(new Ext.Toolbar.MenuButton({text: 'Home',link:'Home.do',handler: handleMenu,menu: menuHome}),
	        
		{
            text:'Administrative Data',	
            menu: menu  // assign menu by instance
        }, 
        {
            text:'Biospecimen Data',
            menu: menu_bio  // assign menu by instance
        },
		{
       		text: 'Search',
            menu: menu_search  // assign menu by instance
        });


    // functions to display feedback


    function onItemCheck(){
		alert("This Page is under construction");
      //  Ext.example.msg('Item Check', 'You {1} the "{0}" menu item.', item.text, checked ? 'checked' : 'unchecked');
    }
	function handleMenu(item)
	{
	document.location.href = item.link;
	}
	
    
});
