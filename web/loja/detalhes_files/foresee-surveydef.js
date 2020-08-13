(function(){

    var FSR;

    // Do we support AMD?
    var supports_amd =
        typeof(window.define) === 'function' && window.define.amd &&
            (!window.FSR || window.FSR.supportsAMD);

    if(!supports_amd)
        FSR = window.FSR;
    else
        FSR = {};

    FSR.surveydefs = [{
    name: 'browse',
    site: 'submarino.com.br',
    invite: {
        when: 'onentry',
        siteLogo: "submarino.gif",
        dialogs: [[{
            reverseButtons: false,
            headline: "Queremos saber a sua opinião",
            /*custom*/
            blurb: "Oi! Você foi selecionado para participar de uma pesquisa de satisfação que nos ajudará a entender como podemos aperfeiçoar sua experiência.",
            /*custom*/
            noticeAboutSurvey: " ",
            attribution: "Esta pesquisa é conduzida por uma empresa independente, a ForeSee Brasil, em nome do Submarino.com.",
            closeInviteButtonText: "Click para fechar.",
            declineButton: "Não, obrigado.",
            acceptButton: "Sim, darei minha opinião.",
            error: "Error",
            warnLaunch: "this will launch a new window"
        
        }]]
    },
    pop: {
        when: 'later'
    },
    tracker: {
        url: 'tracker-submarino.html'
    },
    criteria: {
        sp: 3,
        lf: 2
    },
    include: {
        urls: ['.']
    }
}, {
    name: 'browse',
    site: 'americanas.com.br',
    invite: {
        when: 'onentry',
        siteLogo: "americanas.gif",
        dialogs: [[{
            reverseButtons: false,
            headline: "Queremos saber a sua opinião",
            /*custom*/
            blurb: "Que bom ver você por aqui, no site da Americanas.com. E te selecionamos para participar de uma pesquisa de satisfação que vai nos ajudar a entender como podemos melhorar sua experiência no nosso site.",
            /*custom*/
            noticeAboutSurvey: "Como a pesquisa foi desenvolvida para verificar sua experiência completa, ela será apresentada ao final da sua visita ao nosso site.",
            attribution: "Esta pesquisa é conduzida por uma empresa independente, a ForeSee Brasil, em nome da Americanas.com.",
            closeInviteButtonText: "Click para fechar.",
            declineButton: "Não, obrigado.",
            acceptButton: "Sim, darei minha opinião.",
            error: "Error",
            warnLaunch: "this will launch a new window"
        
        }]]
    },
    pop: {
        when: 'later'
    },
    tracker: {
        url: 'tracker-americanas.html'
    },
    criteria: {
        sp: 1,
        lf: 2
    },
    include: {
        urls: ['.']
    }
}, {
    name: 'browse',
    site: 'soubarato.com.br',
    invite: {
        when: 'onentry',
        siteLogo: "soubarato.gif",
        dialogs: [[{
            reverseButtons: false,
            headline: "Queremos saber a sua opinião",
            /*custom*/
            blurb: "Ela é super importante para ajudar a entender como melhorar a sua experiência com a gente.",
            /*custom*/
            noticeAboutSurvey: "Para verificar sua experiência como um todo, ela será apresentada ao final da sua visita no site. Esta pesquisa é conduzida por uma empresa independente, a ForeSee Brasil, em nome do SouBarato.",
            attribution: "Contamos com a sua participação!",
            closeInviteButtonText: "Click para fechar.",
            declineButton: "Não, obrigado.",
            acceptButton: "Sim, darei minha opinião.",
            error: "Error",
            warnLaunch: "this will launch a new window"
        
        }]]
    },
    pop: {
        when: 'later'
    },
    tracker: {
        url: 'tracker-soubarato.html'
    },
    criteria: {
        sp: 7,
        lf: 2
    },
    include: {
        urls: ['.']
    }
}, {
    name: 'browse',
    site: 'shoptime.com.br',
    invite: {
        when: 'onentry',
        siteLogo: "shoptime.gif",
        dialogs: [[{
            reverseButtons: false,
            headline: "Queremos saber a sua opinião",
            /*custom*/
            blurb: "Olá! Você foi um dos selecionados para participar da nossa pesquisa. Ela é super importante para ajudar a entender como melhorar a sua experiência com a gente.",
            /*custom*/
            noticeAboutSurvey: "Para verificar sua experiência como um todo, ela será apresentada ao final da sua visita no site. Esta pesquisa é conduzida por uma empresa independente, a ForeSee Brasil, em nome do Shoptime.",
            attribution: "Contamos com a sua participação!",
            closeInviteButtonText: "Click para fechar.",
            declineButton: "Não, obrigado.",
            acceptButton: "Sim, darei minha opinião.",
            error: "Error",
            warnLaunch: "this will launch a new window"
        
        }]]
    },
    pop: {
        when: 'later'
    },
    tracker: {
        url: 'tracker-shoptime.html'
    },
    criteria: {
        sp: 2,
        lf: 2
    },
    include: {
        urls: ['.']
    }
}];
FSR.properties = {
    repeatdays: 90,
    
    repeatoverride: false,
    
    altcookie: {},
    
    language: {
        locale: 'br'
    },
    
    exclude: {},
    /* Invite branding sample property
     brands : [{"c":"Foresee","p":33}, {"c":"Answers", "p":33}, {"c":"ForeseeByAnswers", "p":33}],
     */
    zIndexPopup: 10000,
    
    ignoreWindowTopCheck: false,
    
    ipexclude: 'fsr$ip',
    
    mobileHeartbeat: {
        delay: 60, /*mobile on exit heartbeat delay seconds*/
        max: 3600 /*mobile on exit heartbeat max run time seconds*/
    },
    
    invite: {
    
        // For no site logo, comment this line:
        siteLogo: "sitelogo.gif",
        
        //alt text fore site logo img
        siteLogoAlt: "",
        
        /* Desktop */
        dialogs: [[{
            reverseButtons: false,
            headline: "Queremos saber a sua opinião",
            /*custom*/
            blurb: "Oi! Você foi selecionado para participar de uma pesquisa de satisfação que nos ajudará a entender como podemos aperfeiçoar sua experiência.",
            /*custom*/
            noticeAboutSurvey: "Esta pesquisa é conduzida por uma empresa independente, a ForeSee do Brasil, em nome do Submarino.com.",
            attribution: "Esta pesquisa é conduzida por uma empresa independente, a ForeSee do Brasil, em nome do site que está visitando.",
            closeInviteButtonText: "Click para fechar.",
            declineButton: "Não, obrigado.",
            acceptButton: "Sim, darei minha opinião.",
            error: "Error",
            warnLaunch: "this will launch a new window"
        
        }]],
        
        exclude: {
            urls: ['Carrinho', 'carrinho', 'codItemFusion', '/Login', '/checkout/', '/LoginCk', '/basket.xhtml', '/userChangeAddress.xhtml', '/choosePayment.xhtml', '/userChangeAddress.xhtml', '/basketConfirmacao.xhtml', '/finalizePurchase.xhtml', '/ChangeDeliveryAddress/orderId/', '/FindOrderToCancelOrExchange', '/ReasonsToCancelOrExchange/deliveryId/', '/VoucherList/', '/AllOrders/', '/BankSlipOrders/', '/DebitAccountOrders/', '/DeliveredOrders/', '/GenerateBankSlipLasa/orderId/', '/GenerateBankSlipXml/', '/home/unear/true', '/LastOrders/', '/mobile/MobileLastOrders', '/MobileOrderDetails/orderId/', '/panel/order/danfe', '/panel/OpenedOrders/', '/panel/OrdersByDate/', '/panel/OrdersByNumber/', '/panel/SimplifiedCustomerAllOrders', '/SimplifiedCustomerAuthenticator/orderNumber/', '/GetLastCustomerOrdersRest/', '/RecoveryOrder/number/'],
            referrers: [],
            userAgents: [],
            browsers: [],
            cookies: [],
            variables: []
            // [name (content), http-equiv (content), itemprop (content),  charset] possible attributes for meta tag element http://devdocs.io/html/meta
            // metas:[{"name":{"key":"value", "content":"value"}}, {"http-equiv":{"key":"value", "content":"value"}}, {"itemprop":{"key":"value", "content":"value"}}, {"charset":{"key":"value"}}]
        
        },
        include: {
            local: ['.']
        },
        
        delay: 0,
        timeout: 0,
        
        hideOnClick: false,
        
        hideCloseButton: false,
        
        css: 'foresee-dhtml.css',
        
        hide: [],
        
        hideFlash: false,
        
        type: 'dhtml',
        /* desktop */
        // url: 'invite.html'
        /* mobile */
        url: 'invite-mobile.html',
        back: 'url'
    
        //SurveyMutex: 'SurveyMutex'
    },
    
    tracker: {
        width: '690',
        height: '415',
        timeout: 3,
        adjust: true,
        alert: {
            enabled: true,
            message: 'A pesquisa está disponível agora.'
        },
        url: 'tracker.html'
    },
    
    survey: {
        width: 690,
        height: 600
    },
    
    qualifier: {
        footer: '<div id=\"fsrcontainer\"><div style=\"float:left;width:80%;font-size:8pt;text-align:left;line-height:12px;\">This survey is conducted by an independent company ForeSee,<br>on behalf of the site you are visiting.</div><div style=\"float:right;font-size:8pt;\"><a target="_blank" title="Validate TRUSTe privacy certification" href="//privacy-policy.truste.com/click-with-confidence/ctv/en/www.foreseeresults.com/seal_m"><img border=\"0\" src=\"{%baseHref%}truste.png\" alt=\"Validate TRUSTe Privacy Certification\"></a></div></div>',
        width: '690',
        height: '500',
        bgcolor: '#333',
        opacity: 0.7,
        x: 'center',
        y: 'center',
        delay: 0,
        buttons: {
            accept: 'Continue'
        },
        hideOnClick: false,
        css: 'foresee-dhtml.css',
        url: 'qualifying.html'
    },
    
    cancel: {
        url: 'cancel.html',
        width: '690',
        height: '400'
    },
    
    pop: {
        what: 'survey',
        after: 'leaving-site',
        pu: false,
        tracker: true
    },
    
    meta: {
        referrer: true,
        terms: true,
        ref_url: true,
        url: true,
        url_params: false,
        user_agent: false,
        entry: false,
        entry_params: false,
        viewport_size: false,
        document_size: false,
        scroll_from_top: false,
        invite_URL: false
    },
    
    events: {
        enabled: true,
        id: true,
        codes: {
            purchase: 800,
            items: 801,
            dollars: 802,
            followup: 803,
            information: 804,
            content: 805
        },
        pd: 7,
        custom: {
            purchase: {
                enabled: true,
                repeat: false,
                source: 'url',
                patterns: ['basketConfirmacao.xhtml', 'finalizePurchase.xhtml']
            }
        }
    },
    
    previous: false,
    
    analytics: {
        google_local: false,
        google_remote: false
    },
    
    cpps: {},
    
    mode: 'first-party'
};


    if(supports_amd)
        define(function(){ return FSR; })
})();
